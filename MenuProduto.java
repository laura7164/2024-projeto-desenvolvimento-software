import java.util.Scanner;

public class MenuProduto {

    Scanner leitor = new Scanner(System.in);
    private int opcao;

    public void executarMenuProduto() {
        do {
            System.out.println("[1] Sabão em pó - R$ 33,16");
            System.out.println("[2] Multiuso - R$ 9,90");
            System.out.println("[3] Desinfetante - R$ 8,72");
            System.out.println("[4] Refrigerante - R$ 12,00");
            System.out.println("");

        } while(opcao != 16);
    }
    
}