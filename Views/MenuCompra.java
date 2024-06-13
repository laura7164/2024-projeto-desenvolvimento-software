package Views;
import java.util.Scanner;

public class MenuCompra {

    Scanner leitor = new Scanner(System.in);
    private String resposta;


    public void executarMenuCompra() {
        do{
            //fazer funcao override
            System.out.println("[1] Sabão em pó - R$ 33,16");
            System.out.println("[2] Arroz - R$ 9,90");
            System.out.println("[3] Feijão - R$ 8,72");
            System.out.println("[4] Refrigerante - R$ 12,00");
            System.out.println("[5] Salgadinho - R$ 6,50");

            System.out.print("Digite o código do produto que deseja comprar: ");
            String codigoBuscar = leitor.nextLine();

            //fazer if 

            System.out.print("Deseja continuar comprando?(S/N): ");
            resposta = leitor.nextLine();
                
        }while(resposta.equals("S") || resposta.equals("s"));         
    }
}
