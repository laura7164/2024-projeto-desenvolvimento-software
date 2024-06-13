package Models;

public class Caixa extends Funcionario {
    
    private String turno;
    private int numeroCaixa;
    private boolean statusCaixa;

    public Caixa(String nome, int idFuncionario, String turno, int numeroCaixa, boolean statusCaixa) {
        super(nome, idFuncionario);
        this.salario = 1500;
        this.turno = turno;
        this.numeroCaixa = numeroCaixa;
        this.statusCaixa = false;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public boolean getStatusCaixa() {
        return statusCaixa;
    }

    public void setStatusCaixa(boolean statusCaixa) {
        this.statusCaixa = statusCaixa;
    }

    public boolean abrirCaixa(boolean statusCaixa){
        setStatusCaixa(true);
        return getStatusCaixa();
    }
    
    public boolean fecharCaixa(boolean statusCaixa){
        setStatusCaixa(false);
        return getStatusCaixa();
    }

    @Override
    public void exibirInfo() {
        System.out.println("----------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Id do funcionário: " + getIdFuncionario());
        System.out.println("Turno: " + getTurno());
        System.out.println("Número do caixa: " + getNumeroCaixa());
        System.out.println("----------------------------");
    }

}
