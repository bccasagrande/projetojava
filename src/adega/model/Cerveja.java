package adega.model;

public class Cerveja extends Bebida {

    private String tipo;

    public Cerveja(int codigo, String nome, String marca, float preco, int quantidade, String tipo) {
        super(codigo, nome, marca, preco, quantidade);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Categoria: Cerveja");
    }
}
