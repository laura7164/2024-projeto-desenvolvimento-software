import java.util.Scanner;

public class MenuProduto {

    Scanner leitor = new Scanner(System.in);
    private int opcao;
    private String resposta;

    public void executarMenuProduto() {
        do {
            do{
                System.out.println("[1] Sabão em pó - R$ 33,16");
                System.out.println("[2] Arroz - R$ 9,90");
                System.out.println("[3] Feijão - R$ 8,72");
                System.out.println("[4] Refrigerante - R$ 12,00");
                System.out.println("[5] Salgadinho - R$ 6,50");
                System.out.println("[6] Sair");

                System.out.print("Escolha uma opção: ");
                opcao = leitor.nextInt();

                leitor.nextLine();

                System.out.print("Deseja continuar comprando?(S/N): ");
                resposta = leitor.nextLine();

                switch (opcao) {
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
                    System.out.println("Saindo");
                        break;
                    default:
                    System.out.print("Opção inválida");
                        break;
                }
            }while(resposta.equals("S") || resposta.equals("s"));
              
        } while(opcao != 6);
    }
}
