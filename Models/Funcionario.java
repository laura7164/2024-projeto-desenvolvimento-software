package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario extends Pessoa implements InterfaceFuncionario {
   
    protected float salario;
    private String idFuncionario;
    private List<LocalDateTime> pontosDeEntrada;
    private List<LocalDateTime> pontosDeSaida;
    private List<Compra> compras;

    public Funcionario(String nome, String idFuncionario) {
        super(nome);
        this.idFuncionario = idFuncionario;
        this.pontosDeEntrada = new ArrayList<>();
        this.pontosDeSaida = new ArrayList<>();
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public List<LocalDateTime> getPontosDeEntrada() {
        return pontosDeEntrada;
    }

    public List<LocalDateTime> getPontosDeSaida() {
        return pontosDeEntrada;
    }
    
    public void baterPontoEntrada() {
        LocalDateTime agora = LocalDateTime.now();
        pontosDeEntrada.add(agora);
        System.out.println(getNome() + " bateu o ponto de entrada às " + agora);
    }

    public void baterPontoSaida() {
        LocalDateTime agora = LocalDateTime.now();
        pontosDeSaida.add(agora);
        System.out.println(getNome() + " bateu o ponto de saida às " + agora);
    }

    public void adicionarCompra(Compra compra) {
        if (compras == null) {
            compras = new ArrayList<>();
        }
        compras.add(compra);
    }

}
