# Executar a aplicação

No diretóro raiz da aplicação, executar uma das seguintes opções:

1ª opção.<br>
mvn spring-boot:run

2ª opção.<br>
mvn package && java -jar city-proj-1.0-SNAPSHOT.jar

3ª opção.<br>
Utilizar a IDE Intellij IDEA para abrir o projeto.
Na classe Initializer.java, abrir o menu de contexto e executar o comando "run" ou "debug" Initializer.

# Acessar informações da API

Após subir a aplicação, uma documentação da API (fornecida pelo Swagger) pode ser acessada através do endereço:<br>
http://localhost:8080/swagger-ui.html

# Executando os testes

Executar, na raiz da aplicação:
<b>mvn test</b>
