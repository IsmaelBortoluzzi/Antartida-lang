public class VarDouble extends Variavel{
    
    private Double valor;

    public VarDouble(String name, Double valor) {
        super(name);
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        if (!(valor instanceof Double)) {
            return;
        }
        this.valor = (Double)valor;
    }

}
