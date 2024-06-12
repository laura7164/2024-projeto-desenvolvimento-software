import java.util.Scanner;

public class MenuCliente {

    Scanner leitor = new Scanner(System.in);
    private int opcao;

    public void executarMenuCliente() {
        do {
            System.out.println("[1] Adicionar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Buscar cliente");
            System.out.println("[4] Remover cliente");
            System.out.println("[5] Realizar uma compra");
            System.out.println("[6] Mostrar compras");
            System.out.println("[7] Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println(">> Saindo do sistema...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
           
        } while(opcao != 7);
    }
    
}
