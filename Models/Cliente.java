package Models;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {

    private String cpf;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome);
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void exibirInfo() {
        System.out.println("===================================");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("===================================");
    }

}
