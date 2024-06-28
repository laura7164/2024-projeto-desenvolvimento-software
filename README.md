Sobre o projeto: 
Fizemos um sistema para um mercado, onde poderiamos gerenciar:
- Funcionários, cadastrando os funcionários, listando os funcionários, buscando e removendo eles, contendo cargos de caixa, repositor e gerente.
- Clientes, adicionando clientes, buscando clientes, removendo clientes e listando clientes.
- Estoque, adicionando produtos, listando produtos, atualizando produtos e buscando eles.
- As ações, registrando uma compra de cliente, repondo produtos, batendo ponto de entrada e saída.

  Classes:
-  Todas as classes comentadas abaixo são reunidas nas pastas Models. Temos uma classe abstrata de pessoas, onde é incluído os clientes e funcionários. Funcionários também é uma classe abstrata para abrigar os caixas, os repositores e gerentes. A classe caixa, repositor e gerente tem suas respectivas variáveis, porém adicionando as variáveis dos funcionários e das pessoas. Temos a classe produto, que contem as informações sobre os produtos vendidos, e também temos a classe compra, que armazena as informações sobre a própia. Existe uma interfaceFuncionários que tem as funções de bater ponto de entrada e saída, essa função é extendida pelos funcionários (caixa, repositor e gerente).

- Todas as classes comentadas abaixo são reunidas na pasta Controllers. Essas funções sao utilizadas com menus para realizar as funções comentadas a cima. Na FuncionáriosControllers criamos uma lista de funcionários e temos funções para adicionar funcionários de cada cargo e removê-los, podemos buscar, listar, e atualizar seus turnos e números do caixa. Contém uma função de salvar os funcionários no arquivo e carregar e tambem uma função para retornar a lista de funcionários que será utilizada em outras classes. Possuimos uma função para ver se existem id iguais, caso um funcionários tenha um, nao poderá haver outros iguais. A classe ClienteController é basicamente idêntica a FuncionáriosController, criamos uma lista e uma função para retorna-lá, funções para adicionar, remover, carregar, salvar, etc.. Também temos uma função para ver se existem cpf iguais, caso um cliente tenha um, nao poderá haver outros iguais. EstoqueController não muda quase nada, criamos uma lista, as funções sao as mesmas (adicionar, remover, atualizar) e no final temos uma função para verificar se o código do produto já existe. Na AçãoController temos funções para mostrar funcionários, clientes e produtos, realizar compras e calcular o valor delas, repor produtos e bater o ponto de entrada e saída.
  
- No main criamos objetos para as classes de Controllers, para poder utilizar os menus e as funções das própias.

Como Executar o Projeto:
O sistema é bem fácil de ser executado, os menus favoreceram a agilidade dele, digitando o número da ação desejada. O único problema é que para conseguir usar o menu de ações, primeiramente é necessário acessar o menu de funcionários e listar os funcionários e depois acessar o menu de estoque e listar os produtos.

- Uso do ChatGPT:
O código em si fizemos sozinhas, utilizamos mais o chat para tentar resolver os problemas q apareceram, como o de arquivo e de lista, mas no final o professor acabou nos ajudando. Utilizamos também para ter uma idéia de como fazer a função de realizar compra e bater o ponto.

Não utilizamos referência de nenhum site.
