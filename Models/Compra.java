package Models;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {

    private int idCompra;
    private String idFuncionario;
    private List<Produto> produtos;
    private float valorTotal;
    private LocalDateTime dataHora;

    public Compra(int idCompra, String idFuncionario, List<Produto> produtos, float valorTotal) {
        this.idCompra = idCompra;
        this.idFuncionario = idFuncionario;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.dataHora = LocalDateTime.now();
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
