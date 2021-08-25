package fonte;
public abstract class Variavel {

    private String name;

    public Variavel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getValorAsString();
    public abstract void setValor(Object obj);
}