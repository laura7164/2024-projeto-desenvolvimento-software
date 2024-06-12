import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioController {

    Scanner leitor = new Scanner(System.in);
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public void adicionarCaixa(){
        System.out.print("Digite o nome do caixa: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o id do caixa: ");
        int id = leitor.nextInt();

        leitor.nextLine();

        System.out.print("Digite o turno do caixa: ");
        String turno = leitor.nextLine();

        System.out.print("Digite o número do caixa: ");
        int numeroCaixa = leitor.nextInt();

        Funcionario novoCaixa = new Caixa(nome, id, turno, numeroCaixa, false);
        funcionarios.add(novoCaixa);
    }

    public void adicionarRepositor(){
        System.out.print("Digite o nome do repositor: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o id do repositor: ");
        int id = leitor.nextInt();

        leitor.nextLine();

        System.out.print("Digite o setor do repositor: ");
        String setor = leitor.nextLine();

        Funcionario novoRepositor = new Repositor(nome, id, setor, 0);
        funcionarios.add(novoRepositor);
    }

    public void adicionarGerente(){
        System.out.print("Digite o nome do gerente: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o id do gerente: ");
        int id = leitor.nextInt();

        leitor.nextLine();

        System.out.print("Digite a equipe sob gerência: ");
        String equipe = leitor.nextLine();

        Funcionario novoGerente = new Gerente(nome, id, equipe);
        funcionarios.add(novoGerente);
    }

    public void removerFuncionario(){
        System.out.print("Digite o id do funcionário que deseja remover: ");
        int idRemover = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idRemover == funcionarios.get(i).getIdFuncionario()){
                funcionarios.remove(i);
            }else{
                System.out.println(">> Funcionário não encontrado!");
            }
        }
    }

    public void listarFuncionarios(){
        for(int i = 0; i < funcionarios.size(); i++){
            ((Pessoa) funcionarios).exibirInfo();
        }
    }

    public void buscarFuncionario(){
        System.out.print("Digite o id do funcionário que deseja buscar: ");
        int idBuscar = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idBuscar == funcionarios.get(i).getIdFuncionario()){
                ((Pessoa) funcionarios).exibirInfo();
            }else{
                System.out.println(">> Funcionário não encontrado!");
            }
        }
    }

    public void atualizarFuncionario(){
        System.out.println("Digite o id do funcionário que deseja atualizar: ");
        int idAtualizar = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idAtualizar == funcionarios.get(i).getIdFuncionario()){
                if(funcionarios.get(i).getClass() == Caixa.class){
                    System.out.println("[1] Turno");
                    System.out.println("[2] Número do caixa");
                    
                    System.out.print("Escolha uma opção: ");
                    int opcao = leitor.nextInt();

                    switch(opcao){
                        case 1:
                            System.out.print("Deseja mudar para qual turno? ");
                            System.out.println("[1] Manhã");
                            System.out.println("[2] Noite");
                            
                            int opcao2 = leitor.nextInt();

                            if(opcao2 == 1){
                                ((Caixa)funcionarios).setTurno("Manhã");
                            }

                            if(opcao2 == 2){
                                ((Caixa)funcionarios).setTurno("Noite");
                            }
                            break;
                        case 2:
                            System.out.print("Digite o novo número do caixa: ");
                            int novoNumCaixa = leitor.nextInt();

                            ((Caixa)funcionarios).setNumeroCaixa(novoNumCaixa);
                            break;
                        default:
                            System.out.println(">> Opção inválida...");
                            break;
                    }
               } else if(funcionarios.get(i).getClass() == Repositor.class){
                    System.out.println("[1] Setor");
                    System.out.println("[2] Quantidade de produtos repostos");

                    System.out.print("Escolha uma opção: ");
                    int opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o novo setor: ");
                            String novoSetor = leitor.nextLine();

                            ((Repositor)funcionarios).setSetor(novoSetor);
                            break;
                        case 2:
                            System.out.print("Digite a quantidade atualizada de produtos repostos: ");
                            int novaQuantidadeProdutosRepostos = leitor.nextInt();

                            ((Repositor)funcionarios).setProdutosRepostos(novaQuantidadeProdutosRepostos);
                            break;
                        default:
                            System.out.println(">> Opção inválida...");
                            break;
                    }
               } else if(funcionarios.get(i).getClass() == Gerente.class){
                    System.out.print("Digite a nova equipe sob gerência: ");
                    String novaEquipe = leitor.nextLine();

                    ((Gerente) funcionarios).setEquipe(novaEquipe);
               }
            } else {
                System.out.println(">> Funcionário não encontrado!");
            }
        }
    }

}
