package Controllers;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import Models.Produto;

public class EstoqueController {

    Scanner leitor = new Scanner(System.in);
    List<Produto> estoque = new ArrayList<Produto>();

    public void adicionarProduto(){
        System.out.print("Digite o nome do produto: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o código do produto: ");
        String codigo = leitor.nextLine();

        System.out.print("Digite o preço do produto: ");
        float preco = leitor.nextFloat();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = leitor.nextInt();

        Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
        estoque.add(novoProduto);
    }

    public void listarProdutos(){
        for(int i = 0; i < estoque.size(); i++){
            ((Produto) estoque).verProduto();
        }
    }

    public void removerProduto(){
        System.out.print("Digite o código do produto que deseja remover: ");
        String codigoRemover = leitor.nextLine();

        for(int i = 0; i < estoque.size(); i++){
            if(codigoRemover.equals(estoque.get(i).getCodigo())){
                estoque.remove(i);
            }else{
                System.out.println(">> Produto não encontrado!");
            }
        }
    }

    public void buscarProduto(){
        System.out.print("Digite o código do produto que deseja buscar: ");
        String codigoBuscar = leitor.nextLine();

        for(int i = 0; i < estoque.size(); i++){
            if(codigoBuscar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque).verProduto();
            }else{
                System.out.println(">> Produto não encontrado!");
            }
        }
    }

    public void atualizarPreco(){
        System.out.print("Digite o código do produto que deseja atualizar: ");
        String codigoAtualizar = leitor.nextLine();

        System.out.print("Digite o novo preço do produto: ");
        float novoPreco = leitor.nextFloat();

        for(int i = 0; i < estoque.size(); i++){
            if(codigoAtualizar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque).setPreco(novoPreco);
            }
        }
    }
    
}