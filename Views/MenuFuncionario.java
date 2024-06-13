package Views;
import java.util.Scanner;

import Controllers.FuncionarioController;

public class MenuFuncionario {

    Scanner leitor = new Scanner(System.in);
    private int opcao, opcao2; 

    FuncionarioController funcionarioController = new FuncionarioController();

    public void executarMenuFuncionario() {
        do {
            System.out.println("[1] Adicionar funcionário");
            System.out.println("[2] Listar funcionários");
            System.out.println("[3] Buscar funcionário");
            System.out.println("[4] Remover funcionário");
            System.out.println("[5] Atualizar funcionário");
            System.out.println("[6] Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1: 
                    do {
                        System.out.println("[1] Adicionar um caixa");
                        System.out.println("[2] Adicionar um repositor"); 
                        System.out.println("[3] Adicionar um gerente");
                        System.out.println("[4] Sair");

                        System.out.print("Escolha uma opção: ");
                        opcao2 = leitor.nextInt();

                        switch(opcao2) {
                            case 1:
                                funcionarioController.adicionarCaixa();
                                break;
                            case 2:
                                funcionarioController.adicionarRepositor();
                                break;
                            case 3:
                                funcionarioController.adicionarGerente();
                                break;
                            case 4:
                                System.out.println(">> Saindo...");
                                break;
                            default:
                                System.out.println(">> Opção inválida...");
                                break;
                        }
                    } while(opcao2 != 4);
                    break; 
                case 2:
                    funcionarioController.listarFuncionarios();
                    break;
                case 3:
                    funcionarioController.buscarFuncionario();
                    break;
                case 4:
                    funcionarioController.removerFuncionario();
                    break;
                case 5:
                    funcionarioController.atualizarFuncionario();
                    break;
                case 6:
                    System.out.println(">> Saindo...");
                    break;
                default:
                    System.out.println(">> Opção inválida...");
                    break;
            }
        } while(opcao != 6);
        
    }
}
