public class VarInt extends Variavel {
    
    private Integer valor;

    public VarInt(String name, Integer valor) {
        super(name);
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}
