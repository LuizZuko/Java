public class Cliente {
    private int id;
    private String nome;
    private String email;

    public Cliente(int idParam, String nomeParam, String emailParam) {
        id = idParam;
        nome = nomeParam;
        email = emailParam;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
}