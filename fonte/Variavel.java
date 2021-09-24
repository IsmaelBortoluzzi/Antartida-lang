public abstract class Variavel {

    private String name;

    public Variavel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printVar() {
        System.out.print(this.getValorAsString());
    }

    public abstract String getValorAsString();
    public abstract void setValor(String valor);
}