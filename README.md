# projeto-desenvolvimento-software

Classe Main 
Menu: 
- [1] - Gerenciar funcionários e/ou atividades 
- [2] - Gerenciar clientes e/ou realizar compras 
- [3] - Estoque de produtos 

Classe MenuEstoque 
- [1] - Adicionar Produto 
- [2] - Remover Produto 
- [3] - Listar Produtos 
- [4] - Alterar preço de um Produto 
 
Classe EstoqueController
- Função para adicionar produto (perguntar a quantidade do produto) 
- Função para remover produto 
- Função para listar produto 
- Função para alterar preço do produto
 
Classe MenuFuncionario 
- [1] - Adicionar um funcionário 
    - [1] - Adicionar um caixa 
    - [2] - Adicionar um repositor 
    - [3] - Adicionar um gerente 
- [2] - Listar funcionários 
- [3] - Buscar funcionário 
- [4] - Remover funcionário 
- [5] - Atualizar funcionário 

Classe FuncionarioController 
- Função adicionar funcionário 
- Função listar funcionários 
- Função buscar funcionário 
- Função remover funcionário 
- Função gerar relatório 
- Função exibir relatórios 

Classe MenuCliente 
- [1] - Adicionar um cliente 
- [2] - Listar cliente 
- [3] - Buscar cliente 
- [4] - Remover cliente 
- [5] - Realizar uma compra 
- [6] - Mostrar compras 

Menu de compra 
- [1] Sabão em pó - R$ 33,16
- [2] Arroz - R$ 9,90
- [3] Feijão - R$ 8,72
- [4] Refrigerante - R$ 12,00
- [5] Salgadinho - R$ 6,50

Classe ClienteController
- Função adicionar cliente 
- Função listar clientes 
- Função buscar cliente 
- Função remover cliente 
- Função registrar compra 
- Função visualizar compra

Classe Pessoa (abstrata) 
- String nome 
- Construtor para inicializar nome 
- Métodos get e set para os atributos 
- Função abstrata para mostrar as informações da pessoa 

Classe Cliente 
- String cpf 
- String telefone 
- Int cartaoFidelidade 
- Construtor para inicializar cpf, telefone e cartaoFidelidade 
- Métodos get e set para os atributos 
- Função para adicionar pontos ao cartão fidelidade do cliente 

Classe Funcionario (abstrata) 
- Float salario 
- Int idFuncionario 
- Construtor para inicializar salario e idFuncionario 
- Métodos get e set para os atributos 
- Função para calcular salario 

Classe Caixa  
- String turno 
- Int numeroCaixa 
- Construtor para inicializar turno e numeroCaixa 
- Métodos get e set para os atributos 
- Função para registrar uma venda 
- Função para fechar o caixa no final do turno 

Classe Repositor  
- String setor (setor do mercado onde o repositor trabalha, hortifruti, laticínios) 
- Int produtosRepostos 
- Construtor para inicializar setor e produtosRepostos 
- Métodos get e set para os atributos 
- Função para repor produtos nas prateleiras 
- Função para contar os produtos no estoque 

Classe Gerente  
- String equipe 
- Construtor para inicializar equipe 
- Métodos get e set para os atributos 

Classe produto 
- String nome 
- String códigoProduto 
- Float preco 
- Int quantidadeProduto 
- Construtor para inicializar 
- Métodos get e set para os atributos
  
Classe Compra 

 
Interface Funcionario 
- Função trabalhando(); 
- Função descansando(); 

Interface cliente 
- Função comprando();  
