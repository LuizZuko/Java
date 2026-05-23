public class LinhaRelatorio {
    private String categoria;
    private int totalItens;
    private double faturamento;

    public LinhaRelatorio(String categoria, int totalItens, double faturamento) {
        this.categoria = categoria;
        this.totalItens = totalItens;
        this.faturamento = faturamento;
    }

    public String getCategoria() { 
        return this.categoria; 
    }
    public int getTotalItens() { 
        return this.totalItens; 
    }
    public double getFaturamento() { 
        return this.faturamento; 
    }
}