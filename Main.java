import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        int opcao;

        MenuCliente menuCliente = new MenuCliente();
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        MenuEstoque menuEstoque = new MenuEstoque();

        do {
            System.out.println("Bem vindo ao mercado!");
            System.out.println("[1] Gerenciar funcionários");
            System.out.println("[2] Gerenciar clientes e/ou compras");
            System.out.println("[3] Gerenciar estoque de produtos");
            System.out.println("[4] Sair");

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
                    menuEstoque.executarMenuEstoque();
                    break;
                case 4:
                    System.out.println(">> Saindo do sistema...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
        } while(opcao != 4);

    }
}
