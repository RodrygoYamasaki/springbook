# 📚 SpringBook
Esse é uma API REST desenvolvida com Spring Boot para simular as principais funcionalidades de um sistema de biblioteca, com foco nos processos de empréstimos e devoluções de livros.

## 🌐 Tecnologias e Dependências

- **Java:** Linguagem principal do projeto.
- **Maven:** Ferramenta de automação de build e gerenciamento de dependências.
- **Insomnia:** Ferramenta de testes de API REST.
- **Spring Web:** Módulo do Spring responsável pela criação de aplicações web, incluindo suporte a RESTful APIs.
- **Spring Boot DevTools:** Ferramenta que facilita o desenvolvimento, oferecendo recursos como reinicialização automática e live reload.
- **Spring Data JPA:** Abstração da persistência de dados que simplifica a implementação de repositórios usando JPA.
- **Lombok:** Biblioteca que gera automaticamente getters, setters, construtores e outros métodos com anotações simples.
- **H2 Database:** Banco de dados relacional em memória, ideal para testes e desenvolvimento local.
- **Validation:** Ferramenta para validar dados de entrada.

---

## 🧩 Endpoints

**GET /categories**
- Retorna todas as categorias cadastradas.
- Corpo JSON:
  
  ```json
  {
    "id": 1,
    "genre": "Ficção",
    "name": "Aventura"
  }
  ```

**GET /categories/{id}**
- Busca uma categoria específica pelo ID.
- Corpo JSON:

  ```json
  {
  "id": 1,
  "genre": "Ficção",
  "name": "Aventura"
  }
  ```

**POST /categories**
- Cria uma nova categoria.
- Corpo JSON:

  ```json
  {
  "genre": "Romance",
  "name": "Romance Clássico"
  }
  ```

**PUT /categories/{id}**
- Atualiza uma categoria existente pelo ID.
- Corpo JSON:

  ```json
  {
  "genre": "Romance Moderno",
  "name": "Contemporâneo"
  }
  ```

**DELETE /categories/{id}**
- Remove uma categoria específica pelo ID.

---

## 🚀 Como Usar

1. **Clone o repositório:**

   ```bash
   https://github.com/RodrygoYamasaki/springbook.git
   ```

2. **Utilize a IDE de sua escolha (IntelliJ, VS Code, Eclipse, etc.)**
3. **Executar a aplicação:**

   ```bash
   mvn spring-boot:run
   ```
   
4. **Testar a API: Use o Insomnia para enviar requisições HTTP.**
