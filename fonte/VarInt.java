public class VarInt extends Variavel {
    
    private Integer valor;

    public VarInt(String name, Integer valor) {
        super(name);
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }
    public String getValorAsString() {
        return Integer.toString(this.valor);
    }

    public void setValor(String valor) {
        
        if(valor.contains(".")) {
            valor = valor.split("\\.")[0];
        }

        this.valor = Integer.parseInt(valor);
    }

}
