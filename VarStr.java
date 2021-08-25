public class VarStr extends Variavel{
    
    private String valor;

    public VarStr(String name, String valor) {
        super(name);
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        if (!(valor instanceof String)) {
            return;
        }
        this.valor = (String)valor;
    }

}
