import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public static void inserir(String nome, double preco, int estoque, String categoria, String tipoErva) throws Exception {
        String sql = "INSERT INTO produto (nome, preco, quantidade_estoque, categoria, tipo_erva) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, estoque);
            stmt.setString(4, categoria);
            stmt.setString(5, tipoErva);
            stmt.executeUpdate();
        }
    }
}