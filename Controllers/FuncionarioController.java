package Controllers;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.Caixa;
import Models.Funcionario;
import Models.Gerente;
import Models.Pessoa;
import Models.Repositor;

public class FuncionarioController {

    Scanner leitor = new Scanner(System.in);
    List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<Funcionario>();
    }

    public List<Funcionario> getList(){
        return funcionarios;
    }

    public void adicionarCaixa(){
        try {
            System.out.println(">> Adicionando um caixa...");

            System.out.print("Digite o nome do caixa: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o id do caixa: ");
            String id = leitor.nextLine();

            if (existeId(id)) {
                System.out.println(">> Erro: já existe um funcionário com esse id.");
                return;
            }

            System.out.print("Digite o turno do caixa: ");
            String turno = leitor.nextLine();

            System.out.print("Digite o número do caixa: ");
            int numeroCaixa = leitor.nextInt();

            leitor.nextLine();

            if (existeNumeroCaixaNoTurno(numeroCaixa, turno)) {
                System.out.println(">> Erro: já existe um caixa com esse número no mesmo turno.");
                return;
            }

            Funcionario novoCaixa = new Caixa(nome, id, turno, numeroCaixa, false);
            funcionarios.add(novoCaixa);

            System.out.println(">> Caixa adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println(">> Erro: tipo de dado incorreto. Por favor, insira os dados corretamente.");
            leitor.nextLine();
        } catch (Exception e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    public void adicionarRepositor(){
        try {
            System.out.println(">> Adicionando um repositor...");

            System.out.print("Digite o nome do repositor: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o id do repositor: ");
            String id = leitor.nextLine();

            if (existeId(id)) {
                System.out.println(">> Erro: Já existe um funcionário com esse id.");
                return;
            }

            System.out.print("Digite o setor do repositor: ");
            String setor = leitor.nextLine();

            Funcionario novoRepositor = new Repositor(nome, id, setor, 0);
            funcionarios.add(novoRepositor);

            System.out.println(">> Repositor adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println(">> Erro: tipo de dado incorreto. Por favor, insira os dados corretamente.");
            leitor.nextLine();
        } catch (Exception e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    public void adicionarGerente(){
        try {
            System.out.println(">> Adicionando um gerente...");

            System.out.print("Digite o nome do gerente: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o id do gerente: ");
            String id = leitor.nextLine();

            if (existeId(id)) {
                System.out.println(">> Erro: Já existe um funcionário com esse id.");
                return;
            }

            System.out.print("Digite a equipe sob gerência: ");
            String equipe = leitor.nextLine();

            Funcionario novoGerente = new Gerente(nome, id, equipe);
            funcionarios.add(novoGerente);

            System.out.println(">> Gerente adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println(">> Erro: tipo de dado incorreto. Por favor, insira os dados corretamente.");
            leitor.nextLine();
        } catch (Exception e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    public void removerFuncionario(){
        System.out.println(">> Removendo um funcionário...");

        System.out.print("Digite o id do funcionário que deseja remover: ");
        String idFuncionarioRemover = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionarioRemover.equals(funcionarios.get(i).getIdFuncionario())){
                funcionarios.remove(i);
                salvarFuncionarios();
                encontrado = true;
                System.out.println(">> Funcionário removido com sucesso!");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Funcionário não encontrado!");
    }

    public void listarFuncionarios() {
        carregarFuncionarios();

        AcaoController novaAcao = new AcaoController();
        System.out.println("====== Lista de funcionários ======");
        novaAcao.mostrarFuncionarios(funcionarios);
    }

    public void buscarFuncionario(){
        carregarFuncionarios();

        System.out.println(">> Buscando um funcionário...");

        System.out.print("Digite o id do funcionário que deseja buscar: ");
        String idFuncionarioBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionarioBuscar.equals(funcionarios.get(i).getIdFuncionario())){
                ((Pessoa) funcionarios.get(i)).exibirInfo();
                encontrado = true;
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Funcionário não encontrado!");
    }

    public void atualizarFuncionario(){
        carregarFuncionarios();

        System.out.println(">> Atualizando um funcionário...");

        System.out.print("Digite o id do funcionário que deseja atualizar: ");
        String idFuncionarioAtualizar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionarioAtualizar.equals(funcionarios.get(i).getIdFuncionario())){
                encontrado = true;
                AcaoController novaAcao = new AcaoController();
                novaAcao.mostrarFuncionarios(funcionarios);
                
                if(funcionarios.get(i).getClass() == Caixa.class){
                    System.out.println("===================================");
                    System.out.println("[1] Turno");
                    System.out.println("[2] Número do caixa");
                    System.out.println("===================================");
                    
                    System.out.print("Escolha uma opção: ");
                    int opcao = leitor.nextInt();

                    switch(opcao){
                        case 1:
                            System.out.println("===================================");
                            System.out.println("[1] Manhã");
                            System.out.println("[2] Noite");
                            System.out.println("===================================");

                            System.out.print("Deseja mudar para qual turno? ");
                            int opcao2 = leitor.nextInt();

                            if(opcao2 == 1){
                                ((Caixa)funcionarios.get(i)).setTurno("Manhã");
                            }

                            if(opcao2 == 2){
                                ((Caixa)funcionarios.get(i)).setTurno("Noite");
                            }

                            System.out.println(">> Turno atualizado com sucesso!");
                            break;
                        case 2:
                            System.out.print("Digite o novo número do caixa: ");
                            int novoNumCaixa = leitor.nextInt();

                            ((Caixa)funcionarios.get(i)).setNumeroCaixa(novoNumCaixa);
                            System.out.println(">> Número do caixa atualizado com sucesso!");
                            break;
                        default:
                            System.out.println(">> Opção inválida...");
                            break;
                    }
               } else if(funcionarios.get(i).getClass() == Repositor.class){
                    System.out.println("===================================");
                    System.out.println("[1] Setor");
                    System.out.println("[2] Quantidade de produtos repostos");
                    System.out.println("===================================");

                    System.out.print("Escolha uma opção: ");
                    int opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            leitor.nextLine();
                            System.out.print("Digite o novo setor: ");
                            String novoSetor = leitor.nextLine();

                            ((Repositor)funcionarios.get(i)).setSetor(novoSetor);
                            System.out.println(">> Setor atualizado com sucesso!");
                            break;
                        case 2:
                            System.out.print("Digite a quantidade atualizada de produtos repostos: ");
                            int novaQuantidadeProdutosRepostos = leitor.nextInt();

                            ((Repositor)funcionarios.get(i)).setProdutosRepostos(novaQuantidadeProdutosRepostos);
                            System.out.println(">> Quantidade de produtos repostos atualizada com sucesso!");
                            break;
                        default:
                            System.out.println(">> Opção inválida...");
                            break;
                    }
               } else if(funcionarios.get(i).getClass() == Gerente.class){
                    leitor.nextLine();
                    System.out.print("Digite a nova equipe sob gerência: ");
                    String novaEquipe = leitor.nextLine();

                    ((Gerente) funcionarios.get(i)).setEquipe(novaEquipe);
                    System.out.println(">> Equipe atualizada com sucesso!");
               }

               salvarFuncionarios();
            }
        }

        if(!encontrado)
            System.out.println(">> Funcionário não encontrado!");
    }

    public void salvarFuncionarios() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("funcionarios.save"))) {
            os.writeObject(funcionarios);
            System.out.println(funcionarios);
            System.out.println(">> Funcionários salvos com sucesso!");
        } catch (IOException e) {
            System.out.println(">> Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    public void carregarFuncionarios() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("funcionarios.save"))) {
            funcionarios = (List<Funcionario>) is.readObject();
            System.out.println(funcionarios);
            System.out.println(">> Funcionários carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(">> Erro ao carregar funcionários: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean existeId(String id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeNumeroCaixaNoTurno(int numeroCaixa, String turno) {
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getClass() == Caixa.class) {
                Caixa caixa = (Caixa) funcionario;
                if (caixa.getNumeroCaixa() == numeroCaixa && caixa.getTurno().equals(turno)) {
                    return true;
                }
            }
        }
        return false;
    }

}
