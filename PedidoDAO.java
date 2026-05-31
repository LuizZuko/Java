import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void criarPedido(int idCliente, List<PedidoItem> itens) throws Exception {
        try (Connection conn = ConexaoFactory.getConexao()) {
            conn.setAutoCommit(false);
            try {
                
                String sqlEstoque = "UPDATE produto SET quantidade_estoque = quantidade_estoque - ? WHERE id_produto = ? AND quantidade_estoque >= ?";
                try (PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque)) {
                    for (PedidoItem item : itens) {
                        stmtEstoque.setInt(1, item.getQuantidade());
                        stmtEstoque.setInt(2, item.getIdProduto());
                        stmtEstoque.setInt(3, item.getQuantidade());
                        
                        int linhasAfetadas = stmtEstoque.executeUpdate();
                        if (linhasAfetadas == 0) {
                            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto ID: " + item.getIdProduto());
                        }
                    }
                }

                String sqlPedido = "INSERT INTO pedido (id_cliente, status) VALUES (?, 'FINALIZADO')";
                int idPedido = 0;
                try (PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                    stmtPedido.setInt(1, idCliente);
                    stmtPedido.executeUpdate();
                    try (ResultSet rs = stmtPedido.getGeneratedKeys()) {
                        if (rs.next()) {
                            idPedido = rs.getInt(1);
                        }
                    }
                }

               String sqlItemReal = "INSERT INTO pedido_item (id_pedido, id_produto, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmtItem = conn.prepareStatement(sqlItemReal)) {
                    for (PedidoItem item : itens) {
                        stmtItem.setInt(1, idPedido);
                        stmtItem.setInt(2, item.getIdProduto());
                        stmtItem.setInt(3, item.getQuantidade());
                        stmtItem.setDouble(4, item.getPrecoUnitario());
                        stmtItem.addBatch(); 
                    }
                    stmtItem.executeBatch(); 
                }

                conn.commit();
            } catch (Exception ex) {
                conn.rollback();
                throw ex;
            }
        }
    }

    public List<Pedido> listarCompleto() throws Exception {
        Map<Integer, Pedido> mapaPedidos = new LinkedHashMap<>();
        
        String sql = "SELECT p.id_pedido, p.id_cliente, p.status, pi.id_produto, pi.quantidade, pi.preco_unitario " +
                     "FROM pedido p " +
                     "LEFT JOIN pedido_item pi ON p.id_pedido = pi.id_pedido " +
                     "ORDER BY p.id_pedido"; 

                     try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int idPed = rs.getInt("id_pedido");
                
                Pedido pedido = mapaPedidos.computeIfAbsent(idPed, id -> {
                    try {
                        return new Pedido(id, rs.getInt("id_cliente"), rs.getString("status"), new ArrayList<>());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                int idProd = rs.getInt("id_produto");
                if (!rs.wasNull()) {
                    PedidoItem item = new PedidoItem(
                        idProd, 
                        rs.getInt("quantidade"), 
                        rs.getDouble("preco_unitario")
                    );
                    pedido.getItens().add(item);
                }
            }
        }
        return new ArrayList<>(mapaPedidos.values());
    }