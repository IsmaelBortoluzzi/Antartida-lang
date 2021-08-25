import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        List<Variavel> lista = new LinkedList<>();

        lista.add(new VarDouble("a", 28.98));
        lista.add(new VarInt("b", 28));
        lista.add(new VarStr("c", "que abacaxi esse hein"));
        
        for(Variavel var : lista) {

            System.out.println(var.getName() + ": " + var.getValor());
           
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

        Double soma1 = Operacoes.soma(f);
        System.out.println(soma1);
    }

}
