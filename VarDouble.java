public class VarDouble extends Variavel{
    
    private Double valor;

    public VarDouble(String name, Double valor) {
        super(name);
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
