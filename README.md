# Sobre o projeto
API REST de gerenciamento de um estacionamento de carros e motos.

## Tecnologias utilizadas

- Java
- Spring Boot
- Maven
- Hibernate
- Banco de dados H2
- JPA
- RESTful
- Scrum
- JUnit
- JSON e XML

## Dependências

- Java Runtime Environment (JRE) >= 11.0.11
- Java Development Kit (JDK) >= 11.0.11
- Maven >= 3.8.1

## Links Úteis
- Trello do projeto: https://trello.com/b/WGQ4fiWC/teste-backend-java
- Instalação JRE e JDK: https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-20-04-pt

## Instruções:
-Após instalar todas as dependências requeridas, importe o projeto em sua IDE preferida (foi utilizado de IntelliJ). 

- Em seguida, execute o arquivo "pom.xml" (exemplo no IntelliJ):

## Banco de dados
Para este teste foi utilizado banco de dados H2, que pode ser manipulado utilizando a rota:
http://localhost:8080/h2-console

## Swagger da Aplicação 
http://localhost:8080/swagger


## Funcionalidades realizadas
	Criar um cadastro da empresa com os seguintes campos:
	 - Nome;
	 - CNPJ;
	 - Endereço;
	 - Telefone;
	 - Quantidade de vagas para motos;
	 - Quantidade de vagas para carros.
 	  * Todos os campos são de preenchimento obrigatório.

	Criar um cadastro de veículos com os seguintes campos:

	 - Marca;
	 - Modelo;
	 - Cor;
	 - Placa;
	 - Tipo.
	 * Todos os campos são de preenchimento obrigatório.


## Perguntas 
1 - GraPHQL 
   Pergunta 1 - GraphQL é uma linguagem de consulta para APIs e um tempo de execução que permite aos clientes solicitar exatamente os dados de que precisam. Ele foi desenvolvido para que não seja necessário, múltiplas chamadas, como a API Retfull tradicional
   Pergunta 2 - Para implementar o uso do GraphQL como BFF no projeto deste teste, uma ideia seria utilizar o GraphQL para unificar as chamadas de dados, servindo como um mecanismo de retorno de dados entre o frontend e diversos serviços backend, tais como os sistemas de autenticação, gerenciamento de usuários, veículos, e as vagas do estacionamento. Isso traria mais flexibilidade e retornaria apenas os dados necessários. Poderia ser criado modelos para cada uma das chamadas, administrando o retorno somente com os dados necessários. 
   Pergunta 3 - Com REST Api tradicional, pode-se obter mais dados do que realmente precisa porque a estrutura da resposta é fixa. Quando você precisa dos dados de várias fontes, pode ser necessário bater nos endpoints REST várias vezes. O que pode comprometer a performance da aplicação. Com GRAPHQL você pode ter consultas aninhadas em uma única requisição o que facilita o retorno dos dados e aumenta a performance da aplicação. 

2 - BANCO DE DADOS 
   Pergunta 1 - Um banco de dados relacional é um sistema de armazenamento de dados organizado em tabelas, que estão inter-relacionadas por meio de chaves. Chave Primária - É uma coluna (ou conjunto de colunas) que identifica de forma única cada registro em uma tabela. Chave Estrangeira é uma coluna que cria um vínculo entre duas tabelas, apontando para a chave primária de outra tabela. 
   Pergunta 2 - Após ter criado as tabelas necessárias com os dados de cada uma delas. Podemos organizar da seguinte maneira a estrutura: 
                Relacionamentos
		Veículo e Proprietário: Relacionamento de "muitos para um" (um proprietário pode ter vários veículos).
		Registro de Entrada/Saída e Veículo: Relacionamento de "muitos para um" (um veículo pode ter múltiplos registros ao longo do tempo).
		Registro de Entrada/Saída e Vaga: Relacionamento de "muitos para um" (uma vaga pode ter múltiplos registros de veículos diferentes ao longo do tempo).

   Pergunta 3 - Bancos NoSQL são projetados para escalar horizontalmente, permite armazenar dados sem uma estrutura rígida. Em um sistema de estacionamento, onde diferentes tipos de veículos (carros, motos, caminhões) podem ter informações variáveis, um banco de dados NoSQL como MongoDB pode se adaptar facilmente a mudanças no esquema sem a necessidade de migrações complexas. Consultas simples, como obter os registros de entrada e saída de um veículo ou verificar se uma vaga está disponível, podem ser mais rápidas em bancos NoSQL. Porem as desvantagens, podem ser que em NoSQL geralmente não suporta relacionamentos complexos como joins entre tabelas. No contexto de um sistema de estacionamento, pode ser necessário cruzar informações entre veículos, vagas e registros de entrada/saída e manter consistência de dados e otimizar consultas pode ser mais trabalhoso.

3 - Agilidade
   Pergunta 1 - Metodologias ágeis são conceitos de desenvolvimento de software que tem como principais objetivos a flexibilidade, a colaboração e a entrega rápida e contínua de valor ao cliente. 
   Pergunta 2 - Para esse projeto adotaria o método SCRUM com abordagem de Sprints curtas, adotando todas as cerimonias que a metodologia prevê ( Planejanemtno, Daylis, Revisao, Entrega e Retrospectiva) 
   Pergunta 3 - Comunicação é vital para qualquer projeto, independente do tamanho. A comunicação deve ser assertiva, clara e distribuída. 
 
4 - Devops
   Pergunta 1 - DevOps é a operação  que integra as equipes de desenvolvimento e operações para melhorar a eficiência em todo o ciclo de vida de uma aplicação, desde o desenvolvimento até a entrega em produção.
   Pergunta 2 - Realizaria as principais ações de Devops, montando pipelines de entrega e integração continua (CI/CD). Monitoramento e Feedback dos ambientes ajudando na comunicação entre e inter equipes e ajustando a infraestrutura de acordo com a necessidade de escalabilidade. 
   Pergunta 3 - Costumo utilizar GIiLab, mas já utilizer Jenkins também para automações. 
   


# Autor:
Fabio Jose Fleck 

Agradeço pela opotunidade e fico a disposição. 