public class VarDouble extends Variavel{
    
    private Double valor;

    public VarDouble(String name, Double valor) {
        super(name);
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
    public String getValorAsString() {
        return Double.toString(this.valor);
    }
    public void setValor(Object valor) {
        if (!(valor instanceof Double)) {
            return;
        }
        this.valor = (Double)valor;
    }
    
}
