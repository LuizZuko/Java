public class PedidoItem {
    private int idProduto;
    private int quantidade;
    private double precoUnitario;

    public PedidoItem(int idProdParam, int qtdParam, double precoParam) {
        idProduto = idProdParam;
        quantidade = qtdParam;
        precoUnitario = precoParam;
    }

    public int getIdProduto() { return idProduto; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
}