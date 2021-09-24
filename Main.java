import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String path = args[0];
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while (line != null) {
                
                line = line.trim();
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
            System.out.println("Ocorreu um erro sintático!");
            e.printStackTrace();
        }
    }
}
