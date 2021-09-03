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
        
        String path = "modelo2.txt";
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while (line != null) {
                //System.out.println(line);
                linhas.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<Variavel> listaDeVars = new LinkedList<>();
 
        try {
            Interpretador.Executa(listaDeVars, linhas);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i<listaDeVars.size(); i++) {
            System.out.println("    "+listaDeVars.get(i).getName() + ": " + listaDeVars.get(i).getValorAsString());
        }
        System.out.println("    "+listaDeVars.size());

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

