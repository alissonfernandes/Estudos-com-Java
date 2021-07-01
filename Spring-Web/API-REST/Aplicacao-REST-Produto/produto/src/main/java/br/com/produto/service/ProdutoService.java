package br.com.produto.service;

import br.com.produto.dto.Produto;
import br.com.produto.model.ProdutoEntity;
import br.com.produto.repository.ProdutoRepository;
import br.com.produto.rest.ProdutoResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    ObjectMapper objectMapper;
    
    public List<ProdutoEntity> findAllProduto(){
        List<ProdutoEntity> produtosEntity = repository.findAll();
        
        for(ProdutoEntity produto : produtosEntity){
            long id = produto.getId();
            produto.add(linkTo(methodOn(ProdutoResource.class).getProduto(id)).withSelfRel());
        }
        
        /*List<Produto> produtos = produtosEntity.stream()
                .map(obj -> new Produto(obj))
                .collect(Collectors.toList());*/
        return produtosEntity;
    }
    
    public ProdutoEntity findProduto(Long id){
        Optional<ProdutoEntity> produto = repository.findById(id);
        produto.get().add(linkTo(methodOn(ProdutoResource.class).getAllProduto()).withRel("List Produtos"));
        //Produto produto = new Produto(repository.findById(id).get());
        return produto.get();
    }
    
    public ProdutoEntity saveProduto(ProdutoEntity produtoEntity){
        return repository.save(produtoEntity);
    }
    
    public ProdutoEntity updateProduto(Long id, ProdutoEntity produto){
        produto.setId(id);
        return repository.save(produto);
    }
    
    public ProdutoEntity delteProduto(Long id){
        repository.deleteById(id);
        return new ProdutoEntity();
    }
}
