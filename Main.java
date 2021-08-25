import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        String path = "C:\\Users\\ismae\\Documents\\vscode_workspace\\modelo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
           //
           //


        }
        Variavel[] f = new Variavel[2];
        f[0] = lista.get(0);
        f[1] = lista.get(1);

        System.out.println(Operacoes.eval(lista.get(0).getValorAsString() + "%" + "2"));
    }

}
