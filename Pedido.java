 import java.util.List;

public class Pedido {
    private int id;
    private int idCliente;
    private String status;
    private List<PedidoItem> itens;

    public Pedido(int idParam, int idCliParam, String statusParam, List<PedidoItem> itensParam) {
        id = idParam;
        idCliente = idCliParam;
        status = statusParam;
        itens = itensParam;
    }

    public int getId() { return id; }
    public int getIdCliente() { return idCliente; }
    public String getStatus() { return status; }
    public List<PedidoItem> getItens() { return itens; }
}

