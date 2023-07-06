# APP ELETRO CONTROL
[![Build and deploy JAR app to Azure Web App - grupo9-pos-tech](https://github.com/kaiqueribe/AppEletroControl5/actions/workflows/azure-webapps-java-jar.yml/badge.svg)](https://github.com/kaiqueribe/AppEletroControl5/actions/workflows/azure-webapps-java-jar.yml)

Fala pessoal, esse é um app de consumo de energia, onde será possível acompanhar em tempo real o consumo de energia da sua residência quando ele for concluído!

## Features para a fase 1:

*  🙋🏽‍♀️API Pessoas: "Leitura e escrita dos verbos HTTP"<br>
*  📒API Endereço: "Leitura e escrita dos verbos HTTP"<br>
*  💻API Eletrodomésticos: "Leitura e escrita dos verbos HTTP"<br>

## Tecnologias e ferramentas utilizadas:

* [Spring initializr]( https://start.spring.io/): Ferramenta para criação de projetos Spring Boot
* [Spring Boot ]( https://spring.io/projects/spring-boot): Framework Web 
* [Spring Boot Starter Web] Dependência para desenvolvimento Web
* Spring Boot Starter Validation] Dependência para validação de formulários
* [Maven]( https://mvnrepository.com/): Gerenciador de dependências do projeto
* [JPA Repository] Gerenciador de interação entre camadas do projeto
* [Lombock] Dependência para requisições HTTP
* [Postman](https://www.postman.com/): Ferramenta para teste de requisições HTTP
* [Open Api - Swagger] Dependência para gerar interface amigável para testes

## Dificuldades encontradas:

Durante o desenvolvimento do projeto encontramos alguns problemas de interpretação na regra de negócio, tais como, quais seriam os limites de desenvolvimento para esta fase: 
* Iria utilizar banco de dados? 
* Seria necessário fazer interação entre as API’s solicitadas?
* Qual seria a forma de fazer as simulações de requisições HTTP das API’s? <br>

Estes foram alguns dos levantamentos feitos pela equipe e a partir deles, começamos a estudar as melhores ferramentas para desenvolver as API’s. E como mencionado nas tecnologias e ferramentas utilizadas focamos nelas em específicos durante o projeto.
Algumas das dificuldades encontradas pelo grupo também foi o nivelamento do conhecimento, alguns já tinham um vasto conhecimento na área e outros com pouco ou iniciando no segmento. A partir desse ponto, realizamos algumas reuniões de alinhamento e planejamento do que seria feito e como seria. Passado algumas semanas e o projeto andando, tivemos a baixa de alguns integrantes por motivos pessoais e tivemos que reestruturar a dinâmica do projeto.
Durante as lives do Coda Comigo fomos informados que não seria necessário a utilização de banco de dados nessa primeira fase, assim eliminamos a primeira das dúvidas. Durante as lives do Coda Comigo foi mencionado que também para este primeiro momento não seria necessário interação entre as API’s, bastando apenas que houvessem as repostas mapeadas HTTP,  e por último na nossa lista de dúvidas/ dificuldades teríamos que optar por algum meio de fazer estas requisições HTTP e a ferramenta que o grupo decidiu foi o Postman.

## Pontos chaves do projeto:

Durante as reuniões no inicio do projeto definimos algumas informações básicas que as API’s iriam precisar para atender ao projeto, e as mapeamos da seguinte forma:
* API Pessoas:
ID, nome, data de nascimento, CPF e parentesco.
* API Endereço:
CEP, endereço, numero, bairro, cidade, UF e complemento.
* API Eletrodomésticos:
nome, ID, modelo, potência, voltagem e consumo.
Durante o desenvolvimento da API Pessoas e Eletrodomésticos, optamos por não utilizar o grau de parentesco e o consumo respectivamente para esta fase, devido a não obrigatoriedade das interações entre elas.

## Método de utilização da(s) API(s):

Para demonstração de utilização da(s) API(s) será utilizado o Swagger pela sua interface mais amigável, porém dentro do projeto foi gerado um arquivo de importação Jason do Postman que pode ser utilizado colocando as mesmas informações apresentadas no Swagger.
* [Swagger](https://grupo9-pos-tech.azurewebsites.net/swagger-ui/index.html#/) /): Servidor local para teste requisições HTTP (Browser);
* [Arquivo para teste Postman](https://warped-meteor-302132.postman.co/workspace/App-Consumo-Eletro~60891746-3429-418a-9499-910f095c31d9/collection/27681645-57d87472-1132-46fc-8916-268f42ac6cce?action=share&creator=27681645 ): Arquivo para simulação direto na máquina (PC).
