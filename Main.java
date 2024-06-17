import java.util.Scanner;

import Views.MenuAcao;
import Views.MenuCliente;
import Views.MenuEstoque;
import Views.MenuFuncionario;

public class Main {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        int opcao;

        MenuCliente menuCliente = new MenuCliente();
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        MenuEstoque menuEstoque = new MenuEstoque();
        MenuAcao menuAcao = new MenuAcao();
        
        do {
            System.out.println("====== Bem vindo ao mercado ======");
            System.out.println("[1] Gerenciar funcionários");
            System.out.println("[2] Gerenciar clientes");
            System.out.println("[3] Gerenciar ações do funcionário");
            System.out.println("[4] Gerenciar estoque de produtos");
            System.out.println("[5] Sair");
            System.out.println("===================================");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) { 
                case 1:
                    menuFuncionario.executarMenuFuncionario();
                    break;
                case 2:
                    menuCliente.executarMenuCliente();
                    break;
                case 3:
                    menuAcao.executarMenuAcao();
                    break;
                case 4:
                    menuEstoque.executarMenuEstoque();
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
