package adega.model;

public class Destilado extends Bebida {

    private float teorAlcoolico;

    public Destilado(int codigo, String nome, String marca, float preco, int quantidade, float teorAlcoolico) {
        super(codigo, nome, marca, preco, quantidade);
        this.teorAlcoolico = teorAlcoolico;
    }

    public float getTeorAlcoolico() { return teorAlcoolico; }
    public void setTeorAlcoolico(float teor) { this.teorAlcoolico = teor; }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.printf("Teor Alcoólico: %.1f%%%n", this.teorAlcoolico);
        System.out.println("Categoria: Destilado");
    }
}
