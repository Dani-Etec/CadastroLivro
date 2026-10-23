# CadastroLivro

Aplicação backend desenvolvida em Kotlin com Spring Boot para realizar o cadastro, listagem, atualização e exclusão de livros.

## Visão geral

Este projeto foi criado para gerenciar um catálogo de livros em uma API REST. O sistema permite:

- cadastrar novos livros;
- listar todos os livros cadastrados;
- buscar um livro por ID;
- atualizar os dados de um livro existente;
- excluir um livro.

A aplicação utiliza banco de dados H2 em arquivo para persistência local, facilitando o uso e testes sem a necessidade de instalação de um banco externo.

## Tecnologias utilizadas

- Kotlin
- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Hibernate
- H2 Database
- Gradle
- JUnit 5

## Estrutura do projeto

```text
CadastroLivro/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── gradle/
├── data/
│   ├── CadastroLivro.mv.db
│   └── condomanager.mv.db
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   └── br/sp/gov/br/CadastroLivro/
│   │   │       ├── CadastroLivroApplication.kt
│   │   │       ├── controller/
│   │   │       │   └── LivroController.kt
│   │   │       ├── entity/
│   │   │       │   └── Livro.kt
│   │   │       ├── repository/
│   │   │       │   └── LivroRepository.kt
│   │   │       └── service/
│   │   │           └── LivroService.kt
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── kotlin/
│           └── br/sp/gov/br/CadastroLivro/
│               └── CadastroLivroApplicationTests.kt
└── README.md
```

## Componentes principais

### Entidade `Livro`
A entidade representa o modelo principal da aplicação e contém os seguintes campos:

- `id`: identificador único
- `titulo`: título do livro
- `autor`: autor do livro
- `ano`: ano de publicação

A tabela no banco é configurada como `tb_livro`.

### Repositório `LivroRepository`
Extende `JpaRepository<Livro, Long>` e fornece as operações básicas de persistência para a entidade `Livro`.

### Serviço `LivroService`
Contém a lógica de negócio para:

- cadastrar livro;
- listar livros;
- buscar por ID;
- atualizar livro;
- excluir livro.

### Controller `LivroController`
Expõe os endpoints da API REST com base no caminho `/livros`.

## Endpoints da API

### Base URL

```text
http://localhost:8080
```

### Rotas

| Método | Endpoint | Descrição |
| --- | --- | --- |
| POST | `/livros` | Cadastra um novo livro |
| GET | `/livros` | Lista todos os livros |
| PUT | `/livros/{id}` | Atualiza um livro existente |
| DELETE | `/livros/{id}` | Exclui um livro |

### Exemplo de payload

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "ano": 1899
}
```

## Pré-requisitos

Antes de executar o projeto, verifique se você possui instalado em sua máquina:

- JDK 21+
- Gradle (opcional, porque o projeto já inclui o wrapper `gradlew`)
- Git

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/Dani-Etec/CadastroLivro.git
cd CadastroLivro
```

2. Verifique se o JDK está configurado corretamente:

```bash
java -version
```

3. Caso necessário, configure as variáveis de ambiente do Java no ambiente da sua máquina.

## Como executar

### Método 1: usando o Gradle Wrapper

No diretório do projeto, execute:

```bash
./gradlew bootRun
```

No Windows:

```bash
gradlew.bat bootRun
```

### Método 2: build e execução

Para compilar o projeto:

```bash
./gradlew build
```

Em seguida, para iniciar a aplicação:

```bash
java -jar build/libs/CadastroLivro-0.0.1-SNAPSHOT.jar
```

> O nome do arquivo gerado pode variar conforme a versão e o processo de build, mas o comando acima representa o padrão esperado do projeto.

## Banco de dados

A aplicação utiliza H2 em arquivo, configurado em:

```properties
spring.datasource.url=jdbc:h2:file:./data/CadastroLivro
```

Isso significa que os dados serão salvos no diretório `data/` do projeto.

Também é possível acessar o console do banco via:

```text
http://localhost:8080/h2-console
```

Dados de conexão padrão:

- JDBC URL: `jdbc:h2:file:./data/CadastroLivro`
- Usuário: `sa`
- Senha: vazia

## Execução em desenvolvimento

Ao iniciar a aplicação, o Spring Boot irá subir a API na porta:

```text
8080
```

Você pode testar os endpoints com ferramentas como:

- Postman
- Insomnia
- cURL
- HTTPie

## Testes

Para executar os testes automatizados do projeto:

```bash
./gradlew test
```

## Observações

- O projeto está estruturado em camadas: controller, service, repository e entity.
- A aplicação é um backend API REST, sem interface gráfica.
- O banco H2 foi escolhido para facilitar o desenvolvimento e o armazenamento local dos dados.

## Autor

Projeto desenvolvido por Dani-Etec.

## Licença

Este projeto não possui uma licença especificada no repositório.

---

Se quiser, posso também criar uma versão mais detalhada do README em inglês ou incluir exemplos de requisições cURL para cada endpoint da API.
