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
    

    public static void Executa(List<Variavel> listaDeVars, ArrayList<String> linhas){

        for (int i = 0; i < linhas.size(); i++) {
            
            String linha = linhas.get(i);
            
            if(linhas.isEmpty() || linha.startsWith("//")) continue;
            
            String[] splitted;
            linha = linha.trim();

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
                    splitted[1] = splitted[1].trim();
                    splitted[1] = splitted[1].substring(1);
                    String[] vectConta = splitted[1].split("'");

                    splitted[1] = replaceVars(vectConta, listaDeVars);
                    
                    for (Variavel v : listaDeVars) {
                        if (splitted[0].equals(v.getName())) {
                            v.setValor(Double.toString(Operacoes.eval(splitted[1])));
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

                ArrayList<String> linhasDoIf = new ArrayList<>();
                String linhaDoIf = linha.substring(7);
                linhaDoIf = linhaDoIf.trim();

                String[] vectBool = linhaDoIf.split("'");
                linhaDoIf = replaceVars(vectBool, listaDeVars);

                linhasDoIf.add(linhaDoIf);
                int j;
                for(j = 1; !linhaDoIf.startsWith("endif"); j++){

                    linhaDoIf = linhas.get(i+j);
                    linhasDoIf.add(linhaDoIf);
                }
                i = i+j;
                Interpretador.Executa(listaDeVars, linhasDoIf);
            
            }
            else if (linha.startsWith("while")){

                ArrayList<String> linhasDoWhile = new ArrayList<>();
                String linhaDoWhile = linha;
                for(int j = 1; !linhaDoWhile.startsWith("endif"); j++){

                    linhaDoWhile = linhas.get(i+j);
                    linhasDoWhile.add(linha);
                }
            }

        }

        return;
        
    }

}