public class ItemPedido {
    private int id;
    private int idProduto;
    private int quantidadeVolume;
    private double precoUnitario;

    public ItemPedido(int id, int idProduto, int quantidade, double precoUnitario) {
        this.setId(id);
        this.setIdProduto(idProduto);
        this.setQuantidade(quantidade);
        this.setPrecoUnitario(precoUnitario);
    }
    
    public int getId() { return this.id; }
    
    public void setId(int id) { 
        if (id >= 0) {
            this.id = id; 
        }
    }

    public int getIdProduto() { return this.idProduto; }
    
    public void setIdProduto(int idProduto) { 
        if (idProduto > 0) {
            this.idProduto = idProduto; 
        }
    }

    public int getQuantidade() { return this.quantidadeVolume; }
    
    public void setQuantidade(int quantidade) { 
        if (quantidade > 0) {
            this.quantidadeVolume = quantidade; 
        }
    }

    public double getPrecoUnitario() { return this.precoUnitario; }
    
    public void setPrecoUnitario(double precoUnitario) { 
        if (precoUnitario > 0) {
            this.precoUnitario = precoUnitario; 
        }
    }
}
