import java.util.List;
import java.util.ArrayList;

public class Interpretador {

    private static String replaceVars(String[] vect, List<Variavel> listaDeVars) {
        
        for (Variavel v : listaDeVars) {
            
            for (int k = 0; k<vect.length; k++) {
                if (vect[k].equals(v.getName())) {
                    vect[k] = vect[k].replaceAll(v.getName(), v.getValorAsString());
                }
            }
        }
        
        return String.join("", vect);
    }
    
    private static String condicao(String linha,List<Variavel> listaDeVars){

        linha = linha.trim();
        String condicao = linha.substring(7);
        condicao = condicao.replaceAll(" ", "");

        String[] vectBool = condicao.split("'");
        condicao = replaceVars(vectBool, listaDeVars);
        return condicao;

    }

    public static void Executa(List<Variavel> listaDeVars, ArrayList<String> linhas) throws Exception{

        for (int i = 0; i < linhas.size(); i++) {
            
            String linha = linhas.get(i);
            
            if(linhas.isEmpty() || linha.startsWith("//")) continue;
            
            String[] splitted;
            
            if (linha.startsWith("int")) { 

                linha = linha.substring(3);
                linha = linha.replaceAll(" ", "");
                splitted = linha.split("=");

                boolean jaExiste = false;
                for (Variavel v : listaDeVars) {
                    
                    if(v.getName().equals(splitted[0])) {
                        v.setValor(splitted[1]);
                        jaExiste = true;
                        break;
                    }
                }

                if(!jaExiste) listaDeVars.add(new VarInt(splitted[0], Integer.parseInt(splitted[1]))); 
                
            } else if (linha.startsWith("real")) {
                
                linha = linha.substring(4);
                linha = linha.replaceAll(" ", "");
                splitted = linha.split("=");

                boolean jaExiste = false;
                for (Variavel v : listaDeVars) {
                    
                    if(v.getName().equals(splitted[0])) {
                        v.setValor(splitted[1]);
                        jaExiste = true;
                        break;
                    }
                }

                if(!jaExiste) listaDeVars.add(new VarDouble(splitted[0], Double.parseDouble(splitted[1]))); 
                
                
            } else if (linha.startsWith("str")) {
                
                linha = linha.substring(3);
                splitted = linha.split("=");
                splitted[0] = splitted[0].trim();
                splitted[1] = splitted[1].trim();

                splitted[1] = splitted[1].substring(1, (splitted[1].length()-1));
                
                boolean jaExiste = false;
                for (Variavel v : listaDeVars) {
                    
                    if(v.getName().equals(splitted[0])) {
                        v.setValor(splitted[1]);
                        jaExiste = true;
                        break;
                    }
                }
                if(!jaExiste) listaDeVars.add(new VarStr(splitted[0], splitted[1]));
            
            } else if (linha.startsWith("att")) {

                linha = linha.substring(3);
                linha = linha.replaceAll(" ", "");
                splitted = linha.split("=");
                
                if (splitted[1].startsWith("$")) {
                
                    splitted[1] = splitted[1].substring(1);
                    String[] vectConta = splitted[1].split("'");

                    splitted[1] = replaceVars(vectConta, listaDeVars);

                    for (Variavel v : listaDeVars) {
                        if (splitted[0].equals(v.getName())) {
                            v.setValor(Double.toString(Contas.eval(splitted[1])));
                        }
                    } 
                } 
                else {
                    for (Variavel v : listaDeVars) {
                        if (splitted[0].equals(v.getName())) {                        
                            for (Variavel s : listaDeVars) {

                                if (splitted[1].equals(s.getName())) {
                                    v.setValor(s.getValorAsString());
                                    break;
                                }

                            }
                            break;
                        } 
                    }
                }
            }
            else if (linha.startsWith("prints")) {
                linha = linha.substring(6);
                linha = linha.trim();

                if(linha.startsWith("\"") && linha.endsWith("\"")) {

                    linha = linha.substring(1, (linha.length()-1));
                    System.out.print(linha);
                }
                else if(linha.startsWith("$")){
                    linha = linha.substring(1);

                    for (Variavel var : listaDeVars) {
                        if(var.getName().equals(linha)){
                            var.printVar();
                        }
                        
                    }
                }
                else if (linha.startsWith(";")) {
                    System.out.println();
                }
            }
            else if (linha.startsWith("startif")) {

                String condicao = condicao(linha, listaDeVars);

                if(Expressions.evaluate_Expression(condicao)) {

                } else {
                    int j = i+1;
                    int numIfs = 0;

                    while(true) {

                        if(linhas.get(j).equals("endif") && numIfs==0){
                            
                            i = j;
                            break;

                        } else if (linhas.get(j).equals("endif") && numIfs!=0) {
                            numIfs--;
                        }
                        if(linhas.get(j).startsWith("startif")) {
                            
                            numIfs++;
                        }

                        j++;
                    }
                }
            }
            
            else if (linha.startsWith("loopsif")){
                
                String condicao = condicao(linha, listaDeVars);
                
                if(Expressions.evaluate_Expression(condicao)) {

                } 
                else {
                    int k = i+1;
                    int numWhiles = 0;

                    while(true) {

                        if(linhas.get(k).equals("endloop") && numWhiles==0){
                            
                            i = k;
                            break;

                        } else if (linhas.get(k).equals("endloop") && numWhiles!=0) {
                            numWhiles--;
                        }
                        if(linhas.get(k).startsWith("loopsif")) {
                            
                            numWhiles++;
                        }

                        k++;
                    }
                }
            }
            else if(linha.startsWith("endloop")) {

                int l = i-1;
                int numWhiles = 0;

                while(true) {

                    if(linhas.get(l).startsWith("loopsif") && numWhiles==0) {
                        i = l-1;
                        break;
                        
                    } 
                    else if (linhas.get(l).equals("endloop")) {
                        numWhiles++;
                    }
                    if(linhas.get(l).startsWith("loopsif") && numWhiles!=0) {
                        numWhiles--;
                        
                    }     
                    l--;
                }
            }
        }
    }
}
