public class VarDouble extends Variavel{
    
    private Double valor;

    public VarDouble(String name, double valor){

        super(name);
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
    public String getValorAsString() {
        return Double.toString(this.valor);
    }
    public void setValor(String valor) {
        this.valor = Double.parseDouble(valor);
    }
    
}
