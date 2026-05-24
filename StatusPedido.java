public final class StatusPedido {
    public static final int FILA = 1;
    public static final int PROCESSANDO = 2;
    public static final int FINALIZADO = 3;

    private StatusPedido() {}

    public static String paraTexto(int codigo) {
        if (codigo == 1) return "FILA";
        if (codigo == 2) return "PROCESSANDO";
        if (codigo == 3) return "FINALIZADO";
        return "DESCONHECIDO";
    }
}