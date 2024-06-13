package Models;
public abstract class Funcionario extends Pessoa implements InterfaceFuncionario {
   
    protected float salario;
    private int idFuncionario;

    public Funcionario(String nome, int idFuncionario) {
        super(nome);
        this.idFuncionario = idFuncionario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
}
