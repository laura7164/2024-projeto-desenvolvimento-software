package Controllers;
import Models.Compra;
import Models.Funcionario;
import Models.Produto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcaoController {

    Scanner leitor = new Scanner(System.in);
    
    private Map<Integer, Funcionario> funcionarios = new HashMap<>();
    private Map<Integer, Produto> estoque = new HashMap<>();
    private int contadorCompras = 0;

    public void realizarCompra(){
        System.out.print("Digite o seu id: ");
        int idFuncionarioBuscar = leitor.nextInt();

        Funcionario funcionario = funcionarios.get(idFuncionarioBuscar);

        if (funcionario != null) {
            List<Produto> produtosSelecionados = new ArrayList<>();
            while(true) {
                System.out.println("\n=== Produtos Disponíveis ===");
                    for (Produto produto : estoque.values()) {
                        System.out.println(produto.getCodigo() + ": " + produto.getNome() + " - R$ " + produto.getPreco());
                    }
                System.out.println("============================");
                
                System.out.print("Digite o código do produto (ou 0 para finalizar): ");
                String codigoProduto = leitor.nextLine();

                if (codigoProduto.equals(0)) {
                    break;
                }

                Produto produto = estoque.get(codigoProduto);

                if (produto != null) {
                    produtosSelecionados.add(produto);
                    System.out.println(">> Produto adicionado: " + produto.getNome() + " - " + produto.getPreco());
                } else {
                    System.out.println(">> Produto não encontrado!");
                }
            }

            float valorTotal = calcularValorTotal(produtosSelecionados);
            Compra compra = new Compra(++contadorCompras, idFuncionarioBuscar, produtosSelecionados, valorTotal);
            funcionario.adicionarCompra(compra);
            System.out.println(">> Compra registrada com sucesso para " + funcionario.getNome() + ". Valor total: " + valorTotal);

        } else {
            System.out.println(">> Funcionário não encontrado!");
        }
    }

    private float calcularValorTotal(List<Produto> produtosSelecionados) {
        float valorTotal = 0;
        for(Produto produto : produtosSelecionados) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }

    public void reporProduto(){
        System.out.print("Digite o código do produto: ");
        String codigoBuscar = leitor.nextLine();

        for(int i = 0; i < estoque.size(); i++){
            if(codigoBuscar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque).setQuantidade(estoque.get(i).getQuantidade() - 1);
            }
        }
    }

    public void baterPontoEntrada(){
        System.out.print("Digite o seu id: ");
        int idBuscar = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idBuscar == funcionarios.get(i).getIdFuncionario()){
                funcionarios.get(i).baterPontoEntrada();
                System.out.println("Ponto de entrada registrado com sucesso para " + funcionarios.get(i).getNome() + ".");
            } else {
                System.out.println(">> Funcionário não encontrado!");
            }
        }
    }

    public void baterPontoSaida(){
        System.out.print("Digite o seu id: ");
        int idFuncionario = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionario == funcionarios.get(i).getIdFuncionario()){
                funcionarios.get(i).baterPontoSaida();
                System.out.println("Ponto de saida registrado com sucesso para " + funcionarios.get(i).getNome() + ".");
            } else {
                System.out.println(">> Funcionário não encontrado!");
            }
        }
    }
    
}
