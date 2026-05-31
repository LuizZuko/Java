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
                // 1. Atualiza estoque de forma segura
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