## VacinaON

Carteira de vacinação digital.


## Funcionalidades
### Método GET 

### .Carteira de vacinação completa do cliente, busca por id do usuário:
http://localhost:8080/api/v1/user/Vaccines/{{id}}

### .Vacinas que estão prestes a vencer, determinamos os dias e qual usuário:
http://localhost:8080/api/v1/vaccine/days/{{days}}/user/{{id}}

### .Buscamos uma vacina da carteira de vacinação do cliente:
http://localhost:8080/api/v1/vaccine/user/{{id}}/{{name}}

