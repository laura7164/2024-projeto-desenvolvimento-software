package Models;

public class Gerente extends Funcionario {

    private String equipe;

    public Gerente(String nome, String idFuncionario, String equipe) {
        super(nome, idFuncionario);
        this.salario = 3000;
        this.equipe = equipe;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public void exibirInfo() {
        System.out.println("===================================");
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Id do funcionário: " + getIdFuncionario());
        System.out.println("Equipe sob gerencia: " + getEquipe());
        System.out.println("===================================");
    }

}
