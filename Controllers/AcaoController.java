package Controllers;

import Models.Compra;
import Models.Funcionario;
import Models.Produto;
import Models.Cliente;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AcaoController {

    Scanner leitor = new Scanner(System.in);

    private int contadorCompras = 0;

    FuncionarioController funcionarioController = new FuncionarioController();
    EstoqueController estoqueController = new EstoqueController();

    public void mostrarFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirInfo();
        }
    }

    public void mostrarProdutos(List<Produto> estoque){
        for (Produto produto : estoque) {
            produto.exibirInfo();
        }
    }

    public void mostrarClientes(List<Cliente> clientes){
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }

    public void realizarCompra(List<Funcionario> funcionarios, List<Produto> estoque) {
        System.out.println(">> Realizando uma compra...");
    
        funcionarioController.carregarFuncionarios();
    
        System.out.print("Digite o seu id: ");
        String idFuncionarioBuscar = leitor.nextLine();
    
        boolean encontradoFuncionario = false;
    
        for (int i = 0; i < funcionarios.size(); i++) {
            if (idFuncionarioBuscar.equals(funcionarios.get(i).getIdFuncionario())) {
                encontradoFuncionario = true;
    
                estoqueController.carregarProdutos();
                mostrarProdutos(estoque);
    
                List<Produto> produtosComprados = new ArrayList<>();
                String codigoProduto;
    
                do {
                    System.out.print("Digite o código do produto (ou 0 para finalizar): ");
                    codigoProduto = leitor.nextLine();
    
                    if (!codigoProduto.equals("0")) {
                        boolean encontradoProduto = false;
    
                        for (int j = 0; j < estoque.size(); j++) {
                            if (codigoProduto.equals(estoque.get(j).getCodigo())) {
                                encontradoProduto = true;
                                Produto produto = estoque.get(j);
                                produtosComprados.add(produto);
                                System.out.println(">> Produto adicionado: " + produto.getNome() + " - " + produto.getPreco());
                                break;
                            }
                        }
    
                        if (!encontradoProduto) {
                            System.out.println(">> Produto não encontrado!");
                        }
                    }
                } while (!codigoProduto.equals("0"));
    
                if (!produtosComprados.isEmpty()) {
                    float valorTotal = calcularValorTotal(produtosComprados);
                    Compra compra = new Compra(++contadorCompras, idFuncionarioBuscar, produtosComprados, valorTotal);
                    funcionarios.get(i).adicionarCompra(compra);
                    System.out.println(">> Compra registrada com sucesso para " + funcionarios.get(i).getNome() + ". Valor total: " + valorTotal);
                } else {
                    System.out.println(">> Nenhum produto adicionado. Compra não registrada.");
                }
                
                break;
            }
        }
    
        if (!encontradoFuncionario) {
            System.out.println(">> Funcionário não encontrado com o ID fornecido.");
        }
    }

    private float calcularValorTotal(List<Produto> produtosComprados) {
        float valorTotal = 0;

        for(Produto produto : produtosComprados) {
            valorTotal += produto.getPreco();
        }

        return valorTotal;
    }

    public void reporProduto(List<Produto> estoque){
        estoqueController.carregarProdutos();
        
        mostrarProdutos(estoque);

        System.out.print("Digite o código do produto: ");
        String codigoBuscar = leitor.nextLine();

        boolean encontrado = false;

        for (Produto produto : estoque) {
            if (codigoBuscar.equals(produto.getCodigo())) {
                encontrado = true;

                System.out.print("Digite a quantidade de produto que deseja repor: ");
                int quantidadeProdutoRepor = leitor.nextInt();

                if(quantidadeProdutoRepor > produto.getQuantidade())
                    System.out.println(">> Erro: a quantidade em estoque é insuficiente.");
                else {
                    int novaQuantidade = produto.getQuantidade() - quantidadeProdutoRepor;
                    produto.setQuantidade(novaQuantidade);
                
                    estoqueController.salvarProdutos();

                    System.out.println(">> Produto reposto com sucesso! Nova quantidade: " + novaQuantidade);
                }

                break; 
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void baterPontoEntrada(List<Funcionario> funcionarios){
        funcionarioController.carregarFuncionarios();

        System.out.print("Digite o seu id: ");
        String idFuncionarioBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionarioBuscar.equals(funcionarios.get(i).getIdFuncionario())){
                funcionarios.get(i).baterPontoEntrada();
                encontrado = true;
                System.out.println("Ponto de entrada registrado com sucesso para " + funcionarios.get(i).getNome() + ".");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Funcionário não encontrado!");
    }

    public void baterPontoSaida(List<Funcionario> funcionarios){
        funcionarioController.carregarFuncionarios();

        System.out.print("Digite o seu id: ");
        String idFuncionarioBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionarioBuscar.equals(funcionarios.get(i).getIdFuncionario())){
                funcionarios.get(i).baterPontoSaida();
                encontrado = true;
                System.out.println("Ponto de saida registrado com sucesso para " + funcionarios.get(i).getNome() + ".");
                break;
            } 
        }

        if(!encontrado)
            System.out.println(">> Funcionário não encontrado!");
    }
    
}
