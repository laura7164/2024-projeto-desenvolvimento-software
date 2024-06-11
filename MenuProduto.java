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
            System.out.println("[5] Salgadinho - R$ 6,50");
            System.out.println("[6] Bolacha - R$ 3,89");
            System.out.println("[7] Ovo 12 unidades - R$ 28,00");
            System.out.println("[8] Nuggets - R$ 10,98");
            System.out.println("[9] Batata sorriso R$ 12,00");
            System.out.println("[10] Arroz 1kg - R$ 8,09");
            System.out.println("[11] Feijão 1kg - R$ 10,22");
            System.out.println("[12] Farinha - R$ 6,73");
            System.out.println("[13] Sal - R$ 4,68");
            System.out.println("[14] Açucar - R$5,45");
            System.out.println("[15] Oleo - R$ 7,46");
            System.out.println("[16] Sair");
            System.out.println(">>Escolha uma opção");

        } while(opcao != 16);
    }
}
