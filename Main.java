import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Object;
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
            
            if(linha.isEmpty()) continue;
            
            String[] cpy;
            linha = linha.trim();

            if (linha.startsWith("int")) { 

                linha = linha.substring(3);
                linha = linha.replaceAll(" ", "");
                cpy = linha.split("=");

                listaDeVars.add(new VarInt(cpy[0], Integer.parseInt(cpy[1]))); 
                
            } else if (linha.startsWith("float")) {
                
                linha = linha.substring(5);
                linha = linha.replaceAll(" ", "");
                cpy = linha.split("=");
                listaDeVars.add(new VarDouble(cpy[0], Double.parseDouble(cpy[1]))); 
                
            } else if (linha.startsWith("str")) {
                
                linha = linha.substring(3);
                linha = linha.replaceAll(" ", "");
                cpy = linha.split("=");
                cpy[1] = cpy[1].substring(1, (cpy[1].length()-1));

                listaDeVars.add(new VarStr(cpy[0], cpy[1]));
            
            } else if (linha.startsWith("att")) {

                linha = linha.substring(3);
                linha = linha.replaceAll(" ", "");
                cpy = linha.split("=");

                
                for (Variavel v : listaDeVars) {
                    if (cpy[0].equals(v.getName())) {                        
                        for (Variavel s : listaDeVars) {

                            if (cpy[1].equals(s.getName())) {
                                v.setValor(s.getValorAsString());
                            }

                        }
                    } 
                }
            }
        }

        
        System.out.println(listaDeVars.get(0).getName() + ": " + listaDeVars.get(0).getValorAsString());
        System.out.println(listaDeVars.get(1).getName() + ": " + listaDeVars.get(1).getValorAsString());
        System.out.println(listaDeVars.get(2).getName() + ": " + listaDeVars.get(2).getValorAsString());
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

