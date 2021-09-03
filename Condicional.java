import java.util.List;
import java.util.ArrayList;

public class Condicional {

    private String condicao;
    private ArrayList<String> linhas;
    private List<Variavel> listaDeVars;


    public Condicional(String condicao, ArrayList<String> linhas, List<Variavel> listaDeVars) {
        this.condicao = condicao;
        this.linhas = linhas;
        this.listaDeVars = listaDeVars;
    }

    public int Evaluate(){

        
        if(ExpressionParser.evaluate(this.condicao,0,0)){

            System.out.println(this.condicao);
            Interpretador.Executa(listaDeVars, linhas);
            return 1;

        }
        return 0;
    }

    

}