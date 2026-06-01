import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n--- INDÚSTRIA ERVA MATE: CONTROLE CENTRAL ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Produto de Erva Mate / Acessório");
            System.out.println("3. Lançar Pedido de Venda");
            System.out.println("4. Listar Todo o Ecossistema (Clientes, Estoques, Pedidos)");
            System.out.println("5. Relatório 1: Balanço de Preços por Categoria (via View SQL)");
            System.out.println("6. Relatório 2: Fluxo de Volume de Saída (via View SQL)");
            System.out.println("7. Desligar Terminais");
            System.out.println("Escolha uma instrução: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
        }
    }
}