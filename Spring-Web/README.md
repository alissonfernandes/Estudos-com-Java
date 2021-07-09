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

 * **`GET`**: Buscar dados.
 * **`POST`**: Utilizado para criar novas informações.
 * **`PUT`**: Utilizado para alterar informações.
 * **`DELETE`**: Remover dados.

## Extraindo valores
**`@PathVariable Especifica`** que o valor do parâmetro, será indicado na URI. Ex.: _**meusite.com.br**/usuario/{id}_
**`@RequestParam`** Extrai o valor do parâmetro da URI. Ex.: _?idade=10&uf=RS_
**`@RequestBody`** recebe os valores no corpo da requisição.

## Response
* **`ResponseEntity`**: representa toda resposta HTTP. Você pode controlar qualquer coisa que aconteça, código de status, cabeçalhos e corpo.

# Hateoas
Uma API HATEOAS provê informações que permite navegar entre seus endpoints de forma dinâmica incluindo links junto às respostas.

Com isso deixamos a responsabilidade de acessos e ações para o backend da aplicação.

## Filter
*  init(FilterConfig filterConfig);
* Chamado pelo contêiner da web para indicar para um filtro que ele está sendo colocado em serviço.

### `doFilter()`
O doFilter() método do filtro é chamado pelo contêiner toda vez que um par de solicitação/resposta é passado pela cadeia devido a uma solicitação do cliente por um recurso no final da cadeia. O FilterChain transmitido para esse método permite que o Filter transmita a solicitação e a resposta para a próxima entidade na cadeia.

### `destroy();`
Esse método é chamado apenas quando todos os threads no método doFilter tiverem saída ou após um período de tempo limite. Depois que o contêiner da Web chamar esse método, ele não chamará o método do Filter novamente nesta instância do filtro.

