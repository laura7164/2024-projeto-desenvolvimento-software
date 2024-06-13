import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteController {

    Scanner leitor = new Scanner(System.in);
    List<Cliente> clientes = new ArrayList<Cliente>();

    public void adicionarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o cpf do cliente: ");
        String cpf = leitor.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = leitor.nextLine();

        Cliente novoCliente =  new Cliente(nome, cpf, telefone, 0);
        clientes.add(novoCliente);
    }

    public void listarClientes(){
        for(int i = 0; i < clientes.size(); i++){
            ((Pessoa) clientes).exibirInfo();
        }
    }

    public void buscarCliente(){
        System.out.print("Digite o cpf do cliente que deseja buscar: ");
        String cpfBuscar = leitor.nextLine();

        for(int i = 0; i < clientes.size(); i++){
            if(cpfBuscar.equals(clientes.get(i).getCpf())){
                ((Pessoa) clientes).exibirInfo();
            }else{
                System.out.println(">> Cliente não encontrado!");
            }
        }
    }

    public void removerCliente(){
        System.out.print("Digite o cpf do cliente que deseja remover: ");
        String cpfRemover = leitor.nextLine();

        for(int i = 0; i < clientes.size(); i++){
            if(cpfRemover.equals(clientes.get(i).getCpf())){
                clientes.remove(i);
            }else{
                System.out.println(">> Funcionário não encontrado!");
            }
        }
    }

}