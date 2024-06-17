package Controllers;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.Produto;

public class EstoqueController {

    Scanner leitor = new Scanner(System.in);
    List<Produto> estoque = new ArrayList<Produto>();

    public void adicionarProduto(){
        try {
            System.out.println(">> Adicionando um produto...");

            System.out.print("Digite o nome do produto: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o código do produto: ");
            String codigo = leitor.nextLine();

            System.out.print("Digite o preço do produto: ");
            float preco = leitor.nextFloat();

            System.out.print("Digite a quantidade do produto: ");
            int quantidade = leitor.nextInt();

            leitor.nextLine();

            Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
            estoque.add(novoProduto);

            System.out.println(">> Produto adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println(">> Erro: tipo de dado incorreto. Por favor, insira os dados corretamente.");
            leitor.nextLine();
        } catch (Exception e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    public void listarProdutos(){
        System.out.println("====== Lista de produtos =========");
        for(int i = 0; i < estoque.size(); i++){
            ((Produto) estoque.get(i)).verProduto();
        }
    }

    public void removerProduto(){
        System.out.println(">> Removendo um produto...");

        System.out.print("Digite o código do produto que deseja remover: ");
        String codigoProdutoRemover = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < estoque.size(); i++){
            if(codigoProdutoRemover.equals(estoque.get(i).getCodigo())){
                estoque.remove(i);
                encontrado = true;
                System.out.println(">> Produto removido com sucesso!");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void buscarProduto(){
        System.out.println(">> Buscando um produto...");

        System.out.print("Digite o código do produto que deseja buscar: ");
        String codigoProdutoBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < estoque.size(); i++){
            if(codigoProdutoBuscar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque.get(i)).verProduto();
                encontrado = true;
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void atualizarPreco(){
        System.out.println(">> Atualizando o preço de um produto...");

        System.out.print("Digite o código do produto que deseja atualizar: ");
        String codigoProdutoAtualizar = leitor.nextLine();

        boolean encontrado = false;

        System.out.print("Digite o novo preço do produto: ");
        float novoPrecoProduto = leitor.nextFloat();

        leitor.nextLine();

        for(int i = 0; i < estoque.size(); i++){
            if(codigoProdutoAtualizar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque.get(i)).setPreco(novoPrecoProduto);
                encontrado = true;
                System.out.println(">> Preço do produto atualizado com sucesso!");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado");
    }
    
}
