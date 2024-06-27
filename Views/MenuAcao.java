package Views;

import java.util.List;
import java.util.Scanner;
import Controllers.AcaoController;
import Models.Cliente;
import Models.Funcionario;
import Models.Produto;

public class MenuAcao {

    Scanner leitor = new Scanner(System.in);
    private int opcao;

    private AcaoController acaoController = new AcaoController();

    public void executarMenuAcao(List<Funcionario> funcionarioController, List<Produto> estoqueController, List<Cliente> clienteController) {
        do {
            System.out.println("===================================");
            System.out.println("[1] Registrar compra");
            System.out.println("[2] Repor um produto");
            System.out.println("[3] Bater ponto de entrada");
            System.out.println("[4] Bater ponto de saída");
            System.out.println("[5] Sair");
            System.out.println("===================================");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                    acaoController.realizarCompra(funcionarioController, estoqueController);
                    break;
                case 2:
                    acaoController.reporProduto(estoqueController);
                    break;
                case 3:
                    acaoController.baterPontoEntrada(funcionarioController);
                    break;
                case 4:
                    acaoController.baterPontoSaida(funcionarioController);
                    break;
                case 5:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }

        } while(opcao != 5);
    }

}
