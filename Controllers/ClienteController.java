package Controllers;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.Cliente;
import Models.Pessoa;

public class ClienteController {

    Scanner leitor = new Scanner(System.in);
    List<Cliente> clientes = new ArrayList<Cliente>();

    public void adicionarCliente(){
        try {
            System.out.println(">> Adicionando um cliente...");

            System.out.print("Digite o nome do cliente: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o cpf do cliente (xxx.xxx.xxx-xx): ");
            String cpf = leitor.nextLine();

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
        System.out.println("====== Lista de funcionários =========");
        for(int i = 0; i < clientes.size(); i++){
            ((Pessoa) clientes.get(i)).exibirInfo();
        }
    }

    public void buscarCliente(){
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
                encontrado = true;
                System.out.println(">> Cliente removido com sucesso!");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Cliente não encontrado!");
    }

}
