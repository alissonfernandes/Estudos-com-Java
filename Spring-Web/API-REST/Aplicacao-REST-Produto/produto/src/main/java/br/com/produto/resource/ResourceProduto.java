package br.com.produto.resource;

import br.com.produto.model.ProdutoEntity;
import br.com.produto.response.ProdutoListResponse;
import br.com.produto.response.ProdutoResponse;
import br.com.produto.rest.ProdutoResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

@Component
public class ResourceProduto {
    
    public ResourceProduto(ObjectMapper objectMapper){
    }
    
    public ProdutoResponse addLinkFindProduto(ProdutoEntity produtoEntity){
        ProdutoResponse produtoResponse = this.getProdutoResponse(produtoEntity);
        Long id = produtoResponse.getId();
        produtoResponse.add(this.getLinkToListProduto());
        produtoResponse.add(this.getLinkToUpdate(id, produtoEntity));
        produtoResponse.add(this.getLinkToDelete(id));
        return produtoResponse;
    }
    
    public ProdutoResponse addLinkUpdate(Long id, ProdutoEntity produtoEntity){
        ProdutoResponse produtoResponse = this.getProdutoResponse(produtoEntity);
        produtoResponse.add(this.getLinkToProduto(id));
        produtoResponse.add(this.getLinkToListProduto());
        return produtoResponse;
    }
    
   public ProdutoListResponse getLinkListAllProduto(ProdutoEntity produtoEntity){
       Long id = produtoEntity.getId();
       ProdutoListResponse produtoListResponse = new ProdutoListResponse(produtoEntity);
       produtoListResponse.add(getLinkToProduto(id));
       return produtoListResponse;
   }
    
    public ProdutoResponse getProdutoResponse(ProdutoEntity produtoEntity){
        ProdutoResponse produtoResponse = new ProdutoResponse(produtoEntity);
        return produtoResponse;
    }
    
    private Link getLinkToListProduto(){
        return linkTo(methodOn(ProdutoResource.class).getAllProduto()).withRel("List_Produtos");
    }
    
    private Link getLinkToProduto(Long id){
        return linkTo(methodOn(ProdutoResource.class).getProduto(id)).withSelfRel();
    }
    
    private Link getLinkToUpdate(Long id, ProdutoEntity produtoEntity){
        return linkTo(methodOn(ProdutoResource.class).updateProduto(id, produtoEntity)).withRel("update").withTitle("Atualizar dados").withType("PUT");
    }
    
    private Link getLinkToDelete(Long id){
        return linkTo(methodOn(ProdutoResource.class).deleteProduto(id)).withRel("delete").withTitle("Deleatr produto").withType("DELETE");
    }
}
