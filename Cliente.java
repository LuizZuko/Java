public class Cliente {
    private int id;
    private String nome;
    private String email;

    public Cliente(int id, String nome, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
    }
public int getId() { return this.id; }
    
    public void setId(int id) { 
        if (id >= 0) {
            this.id = id; 
        }
    }

    public String getNome() { return this.nome; }
    
    public void setNome(String nome) { 
        if (nome != null && nome.trim().length() > 0) {
            this.nome = nome.trim(); 
        }
    }

    public String getEmail() { return this.email; }
    
    public void setEmail(String email) { 
        if (email != null && email.trim().length() > 0) {
            this.email = email.trim(); 
        }
    }
}
