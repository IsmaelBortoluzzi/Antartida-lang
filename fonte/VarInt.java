package fonte;
public class VarInt extends Variavel {
    
    private Integer valor;

    public VarInt(String name, Integer valor) {
        super(name);
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }
    public String getValorAsString() {
        return String.format("%d", this.valor);
    }


    public void setValor(Object valor) {
        if (!(valor instanceof Integer)) {
            return;
        }
        this.valor = (Integer)valor;
    }

}
