package Views;

import java.util.List;
import java.util.Scanner;
import Controllers.ClienteController;
import Models.Cliente;

public class MenuCliente {

    Scanner leitor = new Scanner(System.in);
    private int opcao;

    ClienteController clienteController = new ClienteController();

    public List<Cliente> getListCliente(){
        return clienteController.getList();
    }

    public void executarMenuCliente() {
        do {
            System.out.println("===================================");
            System.out.println("[1] Adicionar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Buscar cliente");
            System.out.println("[4] Remover cliente");
            System.out.println("[5] Atualizar cliente");
            System.out.println("[6] Salvar clientes em arquivo");
            System.out.println("[7] Carregar clientes do arquivo");
            System.out.println("[8] Sair");
            System.out.println("===================================");

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
                    clienteController.atualizarClientes();
                    break;
                case 6:
                    clienteController.salvarClientes();
                    break;
                case 7:
                    clienteController.carregarClientes();
                case 8:
                    System.out.println(">> Voltando ao menu principal...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
           
        } while(opcao != 8);
    }
    
}
