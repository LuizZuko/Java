public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    private String categoria;
    private String tipoErva;

    public Produto(int idParam, String nomeParam, double precoParam, int estoqueParam, String catParam, String tipoErvaParam) {
        id = idParam;
        nome = nomeParam;
        preco = precoParam;
        estoque = estoqueParam;
        categoria = catParam;
        tipoErva = tipoErvaParam;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public String getCategoria() { return categoria; }
    public String getTipoErva() { return tipoErva; }


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