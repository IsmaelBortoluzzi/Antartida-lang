import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
//import java.lang.Object;
//import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //System.out.println(StringUtils.isNumeric("23"));
        
        String path = "modelo.txt";
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while (line != null) {
                System.out.println(line);
                linhas.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<Variavel> listaDeVars = new LinkedList<>();
 
        for (String linha : linhas) {
            
            if(linha.isEmpty() || linha.startsWith("//")) continue;
            
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
                
            } else if (linha.startsWith("float")) {
                
                linha = linha.substring(5);
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
                linha = linha.replaceAll(" ", "");
                splitted = linha.split("=");
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

                    for (Variavel v : listaDeVars) {
                        
                        for (int i = 0; i<vectConta.length; i++) {
                            if (vectConta[i].equals(v.getName())) {
                                vectConta[i] = vectConta[i].replaceAll(v.getName(), v.getValorAsString());
                            }
                            
                        }
                    }
                    splitted[1] = String.join("", vectConta);
                    
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
                linha = linha.substring(1, (linha.length()-1));
                System.out.println(linha);
            }
        }

        for (int i = 0; i<listaDeVars.size(); i++) {
            System.out.println(listaDeVars.get(i).getName() + ": " + listaDeVars.get(i).getValorAsString());
        }
        System.out.println(listaDeVars.size());

/*

        for (VarInt v : listaDeVars) {

            if (cpy[1].equals(v)) {
                listaDeVars.add(new VarInt(cpy[0], v )); 
            } 

        }

        List<Variavel> lista = new LinkedList<>();

        lista.add(new VarDouble("a", 28.98));
        lista.add(new VarInt("b", 28));
        lista.add(new VarStr("c", "que abacaxi esse hein"));
        
        for(Variavel var : lista) {

            System.out.println(var.getName() + ": " + var.getValorAsString());
           
           //if (var instanceof VarDouble) {
           //    System.out.println(((VarDouble) var).getValor());
           //
           //} else if (var instanceof VarInt) {
           //    System.out.println(((VarInt) var).getValor());
           //
           //} else if (var instanceof VarStr) {
           //    System.out.println(((VarStr) var).getValor());
           //}

        }
        Variavel[] f = new Variavel[2];
        f[0] = lista.get(0);
        f[1] = lista.get(1);


        System.out.println(Operacoes.eval(lista.get(0).getValorAsString() + "%" + "2"));
        */
    }
}

