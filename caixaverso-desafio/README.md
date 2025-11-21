## Rodar o Projeto (Via Docker)

### Passo a Passo
1.  Na raiz do projeto, abra o terminal.
2.  Execute o comando:
    ```bash
    docker-compose up --build
    ```
3.  Aguarde a inicialização. O banco de dados será criado e populado automaticamente.
4.  A API estará disponível em: `http://localhost:8080`.

---

## Acesso e Autenticação

A API é protegida por token JWT. O banco de dados já inicia com um usuário administrativo e dados de teste pré-carregados.

### Credenciais de Acesso Rápido
* **Login:** `admin`
* **Senha:** `senha`

### Como Autenticar no Swagger
1.  Acesse a documentação: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
2.  Vá no endpoint `POST /auth/login` e use as credenciais acima.
3.  Copie o `token` retornado na resposta.
4.  Clique no botão **Authorize** (cadeado) no topo da página.
5.  Cole o token e clique em **Authorize**.
