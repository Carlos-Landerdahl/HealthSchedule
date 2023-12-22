# Health Schedule é um sistema reserva de consulta para clínica odontológica

Este projeto é uma aplicação Java completa construída com Spring Boot, Maven, JPA, JWT para autenticação, e usa DTO para transferência de dados.

## Configuração do Ambiente

Essas instruções o ajudarão a obter uma cópia do projeto em execução em sua máquina local para fins de desenvolvimento e teste.

### Pré-requisitos

O que você precisa para instalar o software e como instalá-los:

- Maven
- H2

## Instalação

Um passo a passo de como configurar um ambiente de desenvolvimento. Exemplo para Windows:

1. Instale o [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
2. Instale o [Maven](https://maven.apache.org/download.cgi)

## Documentação da API com Swagger

A documentação da API está disponível através do Swagger UI. Depois que o aplicativo estiver em execução, você pode acessar a documentação da API visitando `http://localhost:8080/swagger-ui.html` no seu navegador.

Esta documentação fornece uma visão geral interativa de todos os endpoints disponíveis na API, juntamente com os detalhes dos parâmetros de entrada e saída para cada endpoint.

## Executando os Testes

Basta executar os arquivos na pasta testes referente a cada roda criada

## Executando o App

Para executar o projeto, você pode usar o comando `mvn spring-boot:run` na raiz do projeto.

## Construído Com

* [Java](https://www.java.com) - Linguagem de programação
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework para facilitar a configuração e desenvolvimento
* [Maven](https://maven.apache.org/) - Gerenciamento de Dependências
* [JPA](https://spring.io/projects/spring-data-jpa) - Abstração do Hibernate para persistência de dados
* [mockmvc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html) - Usado para testes
* [JWT](https://jwt.io/) - Usado para autenticação e proteção de endpoints
* [springdoc-openapi-ui](https://springdoc.org/) - Usado para geração de documentação
* [spring-boot-starter-security](https://docs.spring.io/spring-security/reference/getting-spring-security.html) - Usado para autenticão de rotas e segurança

## Contribuindo

Por favor, leia [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para detalhes sobre nosso código de conduta, e o processo para enviar pedidos de pull para nós.

## Autores

* **Carlos Roberto landerdahl Neto**
* **Bruno Chaves**
* **Raquel França**

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes
