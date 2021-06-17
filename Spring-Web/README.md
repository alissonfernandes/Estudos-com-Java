# Aplicação REST com Spring MVC
 1. Arquitetura REST com JAX-RS
 2. Hateoas
 3. Jackson & Blnders
 4. Filters

## REST JAX-RS
A necessidade de trocar informações entre aplicações motivou diferentes abordagens para "integração de dados".

E hoje vamos aprender a solução de integração denominada Webservices, que é relativamente simples de implementar, e é mais utilizada hoje em dia.

**JAX-RS** é uma especificação que permite criar RESTful webservices.

O JAX-RS foca bastante URIs e nos detalhes do protocolo HTTP para se beneficiar de seus recursos.

Para acessar os recursos do nosso servidor são utilizados diversas anotações correspondentes aos verbos HTTP, onde os mais utilizados são os:
**GET**: Buscar dados.
**POST**: Utilizado para criar novas informações.
**PUT**: Utilizado para alterar informações.
**DELETE**: Remover dados.

## Extraindo valores
**`@PathVariable Especifica`** que o valor do parâmetro, será indicado na URI. Ex.:meusite.com.br/usuario/{id}
**`@RequestParam`** Extrai o valor do parâmetro da URI. Ex.:?idade=10&uf=RS
**`@RequestBody`** recebe os valores no corpo da requisição.

## Response
**`ResponseEntity`**: representa toda resposta HTTP. Você pode controlar qualquer coisa que aconteça, código de status, cabeçalhos e corpo.