package adega.model;

public abstract class Bebida {

    private int codigo;
    private String nome;
    private String marca;
    private float preco;
    private int quantidade;

    public Bebida(int codigo, String nome, String marca, float preco, int quantidade) {
        this.codigo     = codigo;
        this.nome       = nome;
        this.marca      = marca;
        this.preco      = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public void visualizar() {
        System.out.println("\n*********************************************");
        System.out.println("Dados da Bebida:");
        System.out.println("*********************************************");
        System.out.println("Codigo: "     + this.codigo);
        System.out.println("Nome: "       + this.nome);
        System.out.println("Marca: "      + this.marca);
        System.out.printf("Preço: R$ %,.2f%n", this.preco);
        System.out.println("Quantidade: " + this.quantidade);
    }
}

