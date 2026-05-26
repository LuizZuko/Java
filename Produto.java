public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    private int categoria;

    public Produto(int id, String nome, double preco, int estoque, int categoria) {
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
        this.setEstoque(estoque);
        this.setCategoria(categoria);
    }

    public int getId() { return this.id; }
    public String getNome() { return this.nome; }
    public double getPreco() { return this.preco; }
    public int getEstoque() { return this.estoque; }
    public int getCategoria() { return this.categoria; }
}