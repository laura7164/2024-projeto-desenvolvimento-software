package Views;
import java.util.Scanner;

import Controllers.ClienteController;

public class MenuCliente {

    Scanner leitor = new Scanner(System.in);
    private int opcao;

    ClienteController clienteController = new ClienteController();

    public void executarMenuCliente() {
        do {
            System.out.println("[1] Adicionar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Buscar cliente");
            System.out.println("[4] Remover cliente");
            System.out.println("[5] Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao){
                case 1:
                    clienteController.adicionarCliente();
                    break;
                case 2:
                    clienteController.listarClientes();
                    break;
                case 3:
                    clienteController.buscarCliente();
                    break;
                case 4:
                    clienteController.removerCliente();
                    break;
                case 5:
                    System.out.println(">> Saindo do sistema...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
           
        } while(opcao != 5);
    }
    
}
