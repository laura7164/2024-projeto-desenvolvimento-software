import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        int opcao;

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println(">> Saindo do sistema");
                    break;
                default:
                    System.out.println(">> Opção inválida");
                    break;
            }
        } while(opcao != 4);

    }
}