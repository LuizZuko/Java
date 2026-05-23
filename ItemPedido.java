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

}
