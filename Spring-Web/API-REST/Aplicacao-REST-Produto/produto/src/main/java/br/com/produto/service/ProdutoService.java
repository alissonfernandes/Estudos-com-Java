package br.com.produto.service;

import br.com.produto.model.ProdutoEntity;
import br.com.produto.repository.ProdutoRepository;
import br.com.produto.resource.ResourceProduto;
import br.com.produto.response.ProdutoResponse;
import br.com.produto.rest.ProdutoResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    @Autowired
    private ResourceProduto resourceProduto;
    
    ObjectMapper objectMapper;
    
    public List<ProdutoEntity> findAllProduto(){
        List<ProdutoEntity> produtosEntity = repository.findAll();
        
        for(ProdutoEntity produto : produtosEntity){
            long id = produto.getId();
            produto.add(getLinkToProduto(id));
        }
        return produtosEntity;
    }
    
    public ProdutoResponse findProduto(Long id){
        Optional<ProdutoEntity> produtoEntity = repository.findById(id);
        ProdutoResponse p= resourceProduto.criarLinkCompleto(produtoEntity.get());
       /* p.setId(1L);
        p.setNome("Nome");
        p.setDescricao("descrip");
        p.setEstoque(20);
        p.setPreco(0.0f);*/
        
        /*produto.get().add(getLinkToUpdate(produto.get().getId(), produto.get()));
        produto.get().add(getLinkToDelete(id));
        produto.get().add(getLinkToAllProdutos());*/
        return p;
    }
    
    public ProdutoEntity saveProduto(ProdutoEntity produtoEntity){
        return repository.save(produtoEntity);
    }
    
    public ProdutoEntity updateProduto(Long id, ProdutoEntity produto){
        produto.setId(id);
        return repository.save(produto).add(getLinkToProduto(id), getLinkToAllProdutos());
    }
    
    public ProdutoEntity delteProduto(Long id){
        repository.deleteById(id);
        return new ProdutoEntity();
    }
    
    /*To List_Produtos*/
    private Link getLinkToAllProdutos(){
        return linkTo(methodOn(ProdutoResource.class).getAllProduto()).withRel("List_Produtos");
    }
    
    /*To Produtos*/
    private Link getLinkToProduto(Long id){
        return linkTo(methodOn(ProdutoResource.class).getProduto(id)).withSelfRel();
    }
    
    /*To UPDATE*/
    private Link getLinkToUpdate(Long id, ProdutoEntity produto){
        return linkTo(methodOn(ProdutoResource.class).updateProduto(id, produto)).withRel("update").withTitle("Atualizar dados").withType("PUT");
    }
    
    /*To DELETE*/
    private Link getLinkToDelete(Long id){
        return linkTo(methodOn(ProdutoResource.class).deleteProduto(id)).withRel("delete").withTitle("Deletar produto").withType("DELETE");
    }
}
