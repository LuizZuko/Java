public class PedidoItem {
    private int idProduto;
    private int quantidade;
    private double precoUnitario;

    public PedidoItem(int idProdParam, int qtdParam, double precoParam) {
        idProduto = idProdParam;
        quantidade = qtdParam;
        precoUnitario = precoParam;
    }