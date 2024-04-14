# Projeto FeedFront - Sistema de Gestão Proativa de Feedback

API Rest do projeto FeedFront

## Challenge 2024 - Turma Z (Vissa - Turma Y)

## Integrantes do Grupo:
- Paolla Felix - Desenvolvedor Back-end (Responsável pela implementação das entidades e repositórios)
- Matheus Grando e Blossom Moreira - Desenvolvedora Front-end (Responsável pela implementação dos controladores REST)
- Lais Mendes e Vicenzo Guardabassi - Analista de Qualidade (Responsável pelos testes e pela gestão de configuração)


## Como rodar a aplicação:
### Pré-requisitos:
- Java JDK 11 ou superior instalado e configurado no PATH do sistema.
- Maven instalado e configurado no PATH do sistema.
- MySQL (ou outro banco de dados relacional) instalado e configurado.

### Passos para executar a aplicação:

1. Clone o repositório para o seu ambiente local:
```sh
git clone https://github.com/seu-usuario/projeto-feedfront.git
```
2. Navegar até o diretorio do projeto:
```sh
cd feedfront
```
3. Configure as propriedades do banco de dados no arquivo application.properties localizado em src/main/resources

- Exemplo:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/feedfront
spring.datasource.username=seu-usuario-banco
spring.datasource.password=sua-senha-banco
```

4. Execute o comando Maven para compilar e executar a aplicação:
```sh
mvn spring-boot:run
```
5. Acesse a aplicação em http://localhost:8080

## Imagem dos Diagramas 

![Diagrama de Classes de Entidade](imagens/diagrama_classes.png)
![Diagrama de Entidades e Relacionamento (DER)](imagens/diagrama_der.png)


## Vídeo Apresentação

[Vídeo de apresentação do projeto](LINK_VÍDEO)


## Requisitos

- [x] CRUD de Clientes
- [x] CRUD de FeedbacksV
- [ ] Integração com AI generativa
- [ ] Respostas personalizadas
- [ ] Soluções para problemas identificados
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Clientes](#listar-clientes)
- [Cadastrar Cliente](#cadastrar-cliente)
- [Apagar Cliente](#apagar-cliente)
- [Detalhar Cliente](#detalhar-cliente)
- [Atualizar Cliente](#atualizar-cliente)
- [Listar Feedbacks](#listar-feedbacks)
- [Cadastrar Feedback](#cadastrar-feedback)
- [Apagar Feedback](#apagar-feedback)
- [Detalhar Feedback](#detalhar-feedback)
- [Atualizar Feedback](#atualizar-feedback)


### Listar Clientes

`GET` /clientes

Retorna um array com todos os clientes cadastrados.

#### Exemplo de Resposta

```json
[
    {
        "id": 1,
        "nome": "Billie Eillish",
        "email": "billie@outlook.com"
    }
]

#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Clientes retornados com sucesso
|401| Não autorizado. Realize a autenticação em /login

---

#### Cadastrar Cliente 

`POST` /clientes

Cadastra um cliente com os dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|--------
|nome|string|✅| Nome do cliente
|email|string|✅| Email do cliente

```js

{
    "nome": "Billie Eillish",
    "email": "billie@outlook.com"
}

```
#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Billie Eillish",
    "email": "billie@outlook.com"
}

```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|201| Cliente cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login

---

### Apagar Cliente 

`DELETE` /cliente/`{id}`

Apaga o cliente com o `id` informado no parâmetro de path.

#### Código de Resposta

| código | descrição |
|--------|-----------|
|204| Cliente apagada com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe cliente com o `id` informado


---

### Detalhar Cliente

`GET` /cliente/`{id}`

Retorna os dados do cliente com o `id` informado no parâmetro de path.


#### Exemplo de Resposta

```js
// requisição /clientes/1
{
    "id": 1,
    "nome": "Billie Eillish",
    "email": "billie@outlook.com"
}

```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Cliente retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe categoria com o `id` informado

---

### Atualizar Cliente

`PUT` /cliente/`{id}`

Atualiza os dados do cliente com o `id` informado no path


#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|--------
|nome|string|✅| Nome do cliente
|email|string|✅| Email do cliente

```js
{
    "nome": "Billie Eillish",
    "email": "billie@outlook.com"
}

```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Billie Eillish",
    "email": "billie@outlook.com"
}
```


#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Cliente cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe cliente com o `id` informado

---

### Listar Feedbacks

`GET` /feedbacks

Retorna um array com todos os feedbacks cadastrados.

#### Exemplo de Resposta 

```js
[
    {
        "id": 1,
        "cliente_id": 1,
        "mensagem": "Ótimo atendimento! Parabéns!",
        "data": "2024-04-01T10:00:00Z"
    }
]
```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Feedbacks retornados com sucesso
|401| Não autorizado. Realize a autenticação em /login
---

### Cadastrar Feedback

`POST`/feedbacks

Cadastra um feedback com os dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|--------
|cliente_id|integer|✅| ID do cliente que está dando o feedback
|mensagem|string|✅| Mensagem do feedback
|data|date|✅|Data do feedback (no formato ISO 8601)
---

```js
{
    "cliente_id": 1,
    "mensagem": "Ótimo atendimento! Parabéns!",
    "data": "2024-04-01T10:00:00Z"
}

```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "cliente_id": 1,
    "mensagem": "Ótimo atendimento! Parabéns!",
    "data": "2024-04-01T10:00:00Z"
}

```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|201| Feedback cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login

---

### Apagar Feedback

`DELETE` /feedbacks/{id}

Apaga o feedback com o `id` informado no parâmetro de path.

#### Código de Resposta
