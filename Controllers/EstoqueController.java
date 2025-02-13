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

import Models.Produto;

public class EstoqueController {

    Scanner leitor = new Scanner(System.in);
    List<Produto> estoque;

    public EstoqueController() {
        estoque = new ArrayList<Produto>();
    }

    public List<Produto> getList(){
        return estoque;
    }

    public void adicionarProduto(){
        try {
            System.out.println(">> Adicionando um produto...");

            System.out.print("Digite o nome do produto: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o código do produto: ");
            String codigo = leitor.nextLine();

            if (existeCodigo(codigo)) {
                System.out.println(">> Erro: Já existe um produto com esse código.");
                return;
            }

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
        carregarProdutos();
        
        AcaoController novaAcao = new AcaoController();
        System.out.println("====== Lista de produtos ======");
        novaAcao.mostrarProdutos(estoque);
    }

    public void removerProduto(){
        System.out.println(">> Removendo um produto...");

        System.out.print("Digite o código do produto que deseja remover: ");
        String codigoProdutoRemover = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < estoque.size(); i++){
            if(codigoProdutoRemover.equals(estoque.get(i).getCodigo())){
                estoque.remove(i);
                salvarProdutos();
                encontrado = true;
                System.out.println(">> Produto removido com sucesso!");
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void buscarProduto(){
        carregarProdutos();
        
        System.out.println(">> Buscando um produto...");

        leitor.nextLine();

        System.out.print("Digite o código do produto que deseja buscar: ");
        String codigoProdutoBuscar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < estoque.size(); i++){
            if(codigoProdutoBuscar.equals(estoque.get(i).getCodigo())){
                ((Produto) estoque.get(i)).exibirInfo();
                encontrado = true;
                break;
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void atualizarProduto(){
        carregarProdutos();

        System.out.println(">> Atualizando um produto...");

        leitor.nextLine();

        System.out.print("Digite o código do produto que deseja atualizar: ");
        String codigoProdutoAtualizar = leitor.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < estoque.size(); i++){
            if(codigoProdutoAtualizar.equals(estoque.get(i).getCodigo())){
                encontrado = true;
                AcaoController novaAcao = new AcaoController();
                novaAcao.mostrarProdutos(estoque);

                System.out.println("===================================");
                System.out.println("[1] Preço");
                System.out.println("[2] Quantidade");
                System.out.println("===================================");

                System.out.print("Escolha uma opção: ");
                int opcao = leitor.nextInt();

                switch(opcao){
                    case 1:
                        leitor.nextLine();
                        System.out.print("Digite o novo preço: ");
                        float novoPreco = leitor.nextFloat();

                        ((Produto) estoque.get(i)).setPreco(novoPreco);
                        System.out.println(">> Preço atualizado com sucesso!");
                        break;
                    case 2:
                        leitor.nextLine();
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = leitor.nextInt();

                        ((Produto) estoque.get(i)).setQuantidade(novaQuantidade);
                        System.out.println(">> Quantidade atualizada com sucesso!");
                        break;
                    default:
                        System.out.println(">> Opção inválida...");
                        break;
                }

                salvarProdutos();
            }
        }

        if(!encontrado)
            System.out.println(">> Produto não encontrado!");
    }

    public void salvarProdutos() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estoque.save"))) {
            os.writeObject(estoque);
            System.out.println(estoque);
            System.out.println(">> Produtos salvos com sucesso!");
        } catch (IOException e) {
            System.out.println(">> Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public void carregarProdutos() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("estoque.save"))) {
            estoque = (List<Produto>) is.readObject();
            System.out.println(estoque);
            System.out.println(">> Produtos carregados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(">> Erro ao carregar produtos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean existeCodigo(String codigo) {
        for (Produto produtos : estoque) {
            if (produtos.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
}
