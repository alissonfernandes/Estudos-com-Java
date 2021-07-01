package br.com.produto.service;

import br.com.produto.dto.Produto;
import br.com.produto.model.ProdutoEntity;
import br.com.produto.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    ObjectMapper objectMapper;
    
    public List<Produto> findAllProduto(){
        List<ProdutoEntity> produtosEntity = repository.findAll();
        List<Produto> produtos = produtosEntity.stream()
                .map(obj -> new Produto(obj))
                .collect(Collectors.toList());
        return produtos;
    }
    
    public Produto findProduto(Long id){
        Produto produto = new Produto(repository.findById(id).get());
        return produto;
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
