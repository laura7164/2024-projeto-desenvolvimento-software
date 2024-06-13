package Views;
import java.util.Scanner;

public class MenuAcao {
    
    Scanner leitor = new Scanner(System.in);
    private int opcao;

    public void executarMenuAcao() {
        do {
            System.out.println("[1] Registrar compra");
            System.out.println("[2] Repor um produto");
            System.out.println("[3] Bater ponto de entrada");
            System.out.println("[4] Bater ponto de saída");
            System.out.println("[5] Sair");
            //quantidade produtos no estoque

            System.out.println("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    System.out.println(">> Saindo...");
                    break;

                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }

        } while(opcao != 5);
    }

}