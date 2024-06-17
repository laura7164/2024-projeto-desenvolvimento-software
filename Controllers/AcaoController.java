package Controllers;
import Models.Compra;
import Models.Funcionario;
import Models.Produto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AcaoController {

    Scanner leitor = new Scanner(System.in);
    
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private List<Produto> estoque = new ArrayList<Produto>();
    private List<Produto> produtosComprados = new ArrayList<Produto>();

    private EstoqueController estoqueController = new EstoqueController();

    private int contadorCompras = 0;
    private String codigoProduto;

    public void realizarCompra() {
        System.out.println(">> Realizando uma compra...");

        System.out.print("Digite o seu id: ");
        String idFuncionarioBuscar = leitor.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < funcionarios.size(); i++) {
            if (idFuncionarioBuscar.equals(funcionarios.get(i).getIdFuncionario())) {
                encontrado = true;
                do {
                    estoqueController.listarProdutos();

                    System.out.print("Digite o código do produto (ou 0 para finalizar): ");
                    codigoProduto = leitor.nextLine();

                    if (!codigoProduto.equals("0")) {
                        Produto produto = buscarProdutoPorCodigo(codigoProduto);
                        if (produto != null) {
                            produtosComprados.add(produto);
                            System.out.println(">> Produto adicionado: " + produto.getNome() + " - " + produto.getPreco());
                        } else {
                            System.out.println(">> Produto não encontrado!");
                        }
                    }
                } while (!codigoProduto.equals("0"));

                float valorTotal = calcularValorTotal(produtosComprados);
                Compra compra = new Compra(++contadorCompras, idFuncionarioBuscar, produtosComprados, valorTotal);
                ((Funcionario) funcionarios.get(i)).adicionarCompra(compra);
                System.out.println(">> Compra registrada com sucesso para " + funcionarios.get(i).getNome() + ". Valor total: " + valorTotal);
                produtosComprados.clear();
            }
        }

        if (!encontrado) {
            System.out.println(">> Funcionário não encontrado!");
        }
    }

    private Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    private float calcularValorTotal(List<Produto> produtosComprados) {
        float valorTotal = 0;

        for(Produto produto : produtosComprados) {
            valorTotal += produto.getPreco();
        }

        return valorTotal;
    }

    public void reporProduto(){
        System.out.print("Digite o código do produto: ");
        String codigoBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < estoque.size(); i++){
            if(codigoBuscar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque.get(i)).setQuantidade(estoque.get(i).getQuantidade() - 1);
                encontrado = true;
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void baterPontoEntrada(){
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

    public void baterPontoSaida(){
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
