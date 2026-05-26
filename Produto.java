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

    public void setId(int id) { 
        if (id >= 0) {
            this.id = id; 
        }
    }

    public void setNome(String nome) { 
        if (nome != null && nome.trim().length() > 0) {
            this.nome = nome.trim(); 
        }
    }

    public void setPreco(double preco) { 
        if (preco > 0) {
            this.preco = preco; 
        }
    }

    public void setEstoque(int estoque) { 
        if (estoque >= 0) {
            this.estoque = estoque; 
        }
    }

    public void setCategoria(int categoria) { 
        if (categoria >= 1 && categoria <= 4) {
            this.categoria = categoria; 
        }
    }
}