# Loja virtual
api-loja-virtual foi construída para cadastrar:
* Clientes
* Produtos
* Pedidos

# Procedimento para realizar os cadastros na api
* Authorization: 
  - type: Basic Auth
  - Username: admin 
  - Password: admin
* URL Base - localhost:8080/
* Cliente - listar, listar por id, cadastrar, editar e excluir:
* URL para POST e GET - **localhost:8080/client**
  - Exemplo de body para cadastrar(POST) um novo cliente:
```
{
    "name": "Daniel",
    "email": "daniel@hotmail.com"
}
```
* URL para PUT, DELETE, GET : **localhost:8080/client/1**

Produto - listar, listar por id, cadastrar, editar e excluir:
* URL para POST e GET - **localhost:8080/product**
  - Exemplo de body para cadastrar(POST) um novo produto:
 ```
{
	"description":"novo produto",
	"amount": 10,
	"value": 10.00
}
```
* PUT, DELETE, GET : **localhost:8080/product/1**
 
 
Pedido - cadastrar, deletar e listar por id
* Exemplos de URL's para: 
  - POST - **localhost:8080/order**
  - GET e DELETE - **localhost:8080/order/1**
 
 ```
	{
    "client": {"id": 1},
    "description": "novo pedido",
    "orderItems":[{
                "product":{"id":1}
             },{
                "product":{"id":2}
             }]
    }
	

```
 
###Todos os endPoint's estão no Swagger
 * http://localhost:8080/swagger-ui.html#/
 
### Tecnologias usadas para o desenvolvimento

* Spring Boot
* Spring Security
* Spring Data JPA
* Swagger
* Git
* Maven
* H2
