import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Produto;
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

        List<Produto> estoque = new ArrayList<Produto>();

        estoque.add(new Produto("Sabão em pó", "001", 33.16f, 100));
        estoque.add(new Produto("Arroz", "002", 0.90f, 100));
        estoque.add(new Produto("Feijão", "003", 8.72f, 100));
        estoque.add(new Produto("Refrigerante", "004", 12.00f, 100));
        estoque.add(new Produto("Salgadinho", "005", 6.50f, 100));

        do {
            System.out.println("Bem vindo ao mercado!");
            System.out.println("[1] Gerenciar funcionários");
            System.out.println("[2] Gerenciar clientes");
            System.out.println("[3] Gerenciar ações do funcionário");
            System.out.println("[4] Gerenciar estoque de produtos");
            System.out.println("[5] Sair");

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
