package Views;
import java.util.Scanner;

import Controllers.AcaoController;

public class MenuAcao {
    
    Scanner leitor = new Scanner(System.in);
    private int opcao;

    AcaoController acaoController = new AcaoController();

    public void executarMenuAcao() {
        do {
            System.out.println("[1] Registrar compra");
            System.out.println("[2] Repor um produto");
            System.out.println("[3] Bater ponto de entrada");
            System.out.println("[4] Bater ponto de saída");
            System.out.println("[5] Sair");

            System.out.println("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                    acaoController.realizarCompra();
                    break;
                case 2:
                    acaoController.reporProduto();
                    break;
                case 3:
                    acaoController.baterPontoEntrada();
                    break;
                case 4:
                    acaoController.baterPontoSaida();
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
