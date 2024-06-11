public class Repositor extends Funcionario {

    private String setor;
    private int produtosRepostos;

    public Repositor(String nome, int idFuncionario, String setor, int produtosRepostos) {
        super(nome, idFuncionario);
        this.salario = 1400;
        this.setor = setor;
        this.produtosRepostos = produtosRepostos;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getProdutosRepostos() {
        return produtosRepostos;
    }

    public void setProdutosRepostos(int produtosRepostos) {
        this.produtosRepostos = produtosRepostos;
    }

    public void reporProduto() {
        //
    }

    @Override
    public void exibirInfo() {
        System.out.println("----------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Id do funcionário: " + getIdFuncionario());
        System.out.println("Setor: " + getSetor());
        System.out.println("Quantidade de produtos repostos: " + getProdutosRepostos());
        System.out.println("----------------------------");
    }

    @Override
    public void trabalhar() {
        System.out.println(">> Trabalhando...");
    }

    @Override
    public void descansar() {
        System.out.println(">> Descansando...");
    }
    
}