public class Cliente extends Pessoa implements InterfaceCliente {

    private String cpf;
    private String telefone;
    private int cartaoFidelidade;

    public Cliente(String nome, String cpf, String telefone, int cartaoFidelidade) {
        super(nome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.cartaoFidelidade = cartaoFidelidade;
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

    public int getCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(int cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("----------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Pontos no cartão de fidelidade: " + getCartaoFidelidade());
        System.out.println("----------------------------");
    }

    @Override
    public void comprar() {
        System.out.println(">> Comprando...");
    }

}