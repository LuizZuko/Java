public final class Categoria {
    public static final int TRADICIONAL = 1;
    public static final int MOIDA_GROSSA = 2;
    public static final int COM_CHAS = 3;
    public static final int PREMIUM = 4;

    private Categoria() {}

    public static String paraTexto(int codigo) {
        if (codigo == 1) return "TRADICIONAL";
        if (codigo == 2) return "MOIDA_GROSSA";
        if (codigo == 3) return "COM_CHAS";
        if (codigo == 4) return "PREMIUM";
        return "DESCONHECIDO";
    }
}