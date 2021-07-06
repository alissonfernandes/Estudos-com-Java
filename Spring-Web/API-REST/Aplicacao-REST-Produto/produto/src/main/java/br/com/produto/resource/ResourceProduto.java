package br.com.produto.resource;

import br.com.produto.model.ProdutoEntity;
import br.com.produto.response.ProdutoResponse;
import br.com.produto.rest.ProdutoResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

@Component
public class ResourceProduto {
    
    public ResourceProduto(ObjectMapper objectMapper){
    }
    
    public ProdutoResponse criarLinkCompleto(ProdutoEntity produtoEntity){
        ProdutoResponse produtoResponse = new ProdutoResponse(produtoEntity);
        Link link =  linkTo(methodOn(ProdutoResource.class).getAllProduto()).withRel("List_Produtos");
        produtoResponse.add(link);
        return produtoResponse;
    }
}
