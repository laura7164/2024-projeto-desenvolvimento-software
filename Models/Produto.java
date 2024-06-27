package Models;

import java.io.Serializable;

public class Produto implements Serializable {

    private String nome;
    private String codigo;
    private float preco;
    private int quantidade;

    public Produto(String nome, String codigo, float preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void exibirInfo(){
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPreco());
        System.out.println("Quantidade: " + getQuantidade());
    }
    
    @Override
    public String toString(){
        return "Código: " + getCodigo() + "\nNome: " + getNome() + "\nPreço: " + getPreco() + "\nQuantidade: " + getQuantidade();
    }
}
