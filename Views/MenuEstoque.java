package Views;
import java.util.Scanner;

import Controllers.EstoqueController;

public class MenuEstoque {

    Scanner leitor = new Scanner(System.in);
    int opcao;

    EstoqueController estoqueController = new EstoqueController();

    public void executarMenuEstoque() {
        do {
            System.out.println("[1] Adicionar produto");
            System.out.println("[2] Listar produtos");
            System.out.println("[3] Remover produto");
            System.out.println("[4] Atualizar preço do produto");
            System.out.println("[5] Buscar produto");
            System.out.println("[6] Sair");

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
                    estoqueController.atualizarPreco();
                    break;
                case 5:
                    estoqueController.buscarProduto();
                    break;
                case 6:
                    System.out.println(">> Saindo do sistema...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
        } while(opcao != 6);
        
    }
}
