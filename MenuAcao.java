import java.util.Scanner;

public class MenuAcao {
    
    Scanner leitor = new Scanner(System.in);
    private int opcao;

    public void executarMenuAcao() {
        do {
            System.out.println("[1] Registrar compra");
            System.out.println("[2] Repor um produto");
            System.out.println("[3] Sair");
            //relatorio lucro/quantidade produtos no estoque

            System.out.println("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        } while(opcao != 3);
    }

}