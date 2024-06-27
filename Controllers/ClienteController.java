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

import Models.Cliente;
import Models.Pessoa;

public class ClienteController {

    Scanner leitor = new Scanner(System.in);
    List<Cliente> clientes;

    public ClienteController() {
        clientes = new ArrayList<Cliente>();
    }

    public List<Cliente> getList(){
        return clientes;
    }

    public void adicionarCliente(){
        try {
            System.out.println(">> Adicionando um cliente...");

            System.out.print("Digite o nome do cliente: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o cpf do cliente (xxx.xxx.xxx-xx): ");
            String cpf = leitor.nextLine();

            if (existeCpf(cpf)){
                System.out.println("Erro: já existe um cliente com esse cpf.");
                return;
            }

            System.out.print("Digite o telefone do cliente (xx x xxxx-xxxx): ");
            String telefone = leitor.nextLine();

            Cliente novoCliente =  new Cliente(nome, cpf, telefone);
            clientes.add(novoCliente);

            System.out.println(">> Cliente adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println(">> Erro: tipo de dado incorreto. Por favor, insira os dados corretamente.");
            leitor.nextLine();
        } catch (Exception e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    public void listarClientes(){
        carregarClientes();

        AcaoController novaAcao = new AcaoController();
        System.out.println("====== Lista de clientes ======");
        novaAcao.mostrarClientes(clientes);
    }

    public void buscarCliente(){
        carregarClientes();

        System.out.println(">> Buscando um cliente...");

        System.out.print("Digite o cpf do cliente que deseja buscar: ");
        String cpfClienteBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < clientes.size(); i++){
            if(cpfClienteBuscar.equals(clientes.get(i).getCpf())){
                ((Pessoa) clientes.get(i)).exibirInfo();
                encontrado = true;
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Cliente não encontrado!");
    }

    public void removerCliente(){
        System.out.println(">> Removendo um cliente...");

        System.out.print("Digite o cpf do cliente que deseja remover: ");
        String cpfRemover = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < clientes.size(); i++){
            if(cpfRemover.equals(clientes.get(i).getCpf())){
                clientes.remove(i);
                salvarClientes();
                encontrado = true;
                System.out.println(">> Cliente removido com sucesso!");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Cliente não encontrado!");
    }

    public void atualizarClientes(){
        carregarClientes();

        System.out.print("Digite o CPF do cliente que deseja atualizar: ");
        String atualizarCpfCliente = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < clientes.size(); i++){
            if(atualizarCpfCliente.equals(clientes.get(i).getCpf())){
                encontrado = true;
                AcaoController novaAcao = new AcaoController();
                novaAcao.mostrarClientes(clientes);
                
                System.out.print("Digite o novo número de telefone do cliente: ");
                String novoTelefone = leitor.nextLine();

                clientes.get(i).setTelefone(novoTelefone);

                System.out.println(">> Número do cliente atualizado!");

            }
        }

        if(!encontrado)
            System.out.println(">> Cliente não encontrado!");
    }

    public void salvarClientes() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("clientes.save"))) {
            os.writeObject(clientes);
            System.out.println(clientes);
            System.out.println(">> Clientes salvos com sucesso!");
        } catch (IOException e) {
            System.out.println(">> Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public void carregarClientes() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("clientes.save"))) {
            clientes = (List<Cliente>) is.readObject();
            System.out.println(clientes);
            System.out.println(">> Clientes carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(">> Erro ao carregar clientes: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean existeCpf(String cpf) {
        for (Cliente clientes : clientes) {
            if (clientes.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

}
