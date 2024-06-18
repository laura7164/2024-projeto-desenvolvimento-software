package Views;
import java.util.Scanner;

import Controllers.EstoqueController;

public class MenuEstoque {

    Scanner leitor = new Scanner(System.in);
    int opcao;

    EstoqueController estoqueController = new EstoqueController();

    public void executarMenuEstoque() {
        do {
            System.out.println("===================================");
            System.out.println("[1] Adicionar produto");
            System.out.println("[2] Listar produtos");
            System.out.println("[3] Remover produto");
            System.out.println("[4] Atualizar produto");
            System.out.println("[5] Buscar produto");
            System.out.println("[6] Salvar produtos em arquivo");
            System.out.println("[7] Sair");
            System.out.println("===================================");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao){
                case 1:
                    estoqueController.adicionarProduto();
                    break;
                case 2:
                    estoqueController.listarProdutos();
                    break;
                case 3:
                    estoqueController.removerProduto();
                    break;
                case 4:
                    estoqueController.atualizarProduto();
                    break;
                case 5:
                    estoqueController.buscarProduto();
                    break;
                case 6:
                    estoqueController.salvarProdutos();
                    break;
                case 7:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
        } while(opcao != 7);
        
    }
}
