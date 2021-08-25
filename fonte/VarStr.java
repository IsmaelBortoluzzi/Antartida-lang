package fonte;
public class VarStr extends Variavel{
    
    private String valor;

    public VarStr(String name, String valor) {
        super(name);
        this.valor = valor;
    }

    public String getValorAsString() {
        return this.valor;
    }

    public void setValor(Object valor) {
        if (!(valor instanceof String)) {
            return;
        }
        this.valor = (String)valor;
    }

}
