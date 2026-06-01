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
    
     public static List<Produto> listar() throws Exception {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT id_produto, nome, preco, quantidade_estoque, categoria, tipo_erva FROM produto";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String cat = rs.getString("categoria");
                String tipo = rs.getString("tipo_erva");
                lista.add(new Produto(rs.getInt("id_produto"), rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade_estoque"), cat, tipo));
            }
        }
        return lista;
    }

    public static void ejecutarRelatorioCategorias() throws Exception {
        String sql = "SELECT * FROM vw_balanco_categorias";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("--- RELATÓRIO (SQL VIEW): BALANÇO DE PRODUTOS POR CATEGORIA ---");
            while (rs.next()) {
                System.out.println("Categoria: " + rs.getString("categoria") + " | Variedades: " + rs.getInt("total_itens") + " | Média de Preço: " + rs.getDouble("preco_medio") + " | Estoque Total: " + rs.getInt("estoque_total"));
            }
        }
    }
}