import java.util.List;
import java.util.ArrayList;

public class Condicional {

    private String condiçao;
    private ArrayList<String> linhas;
    private List<Variavel> listaDeVars;


    public Condicional(String condiçao, ArrayList<String> linhas, List<Variavel> listaDeVars) {
        this.condiçao = condiçao;
        this.linhas = linhas;
        this.listaDeVars = listaDeVars;
    }

    public int Evaluate(){

        if(ExpressionParser.evaluate(this.condiçao,0)){

            Interpretador interpretador = new Interpretador(listaDeVars,linhas);
            interpretador.Executa();
            return 1;

        }
        return 0;
    }

    

}