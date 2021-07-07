package br.com.produto.service;

import br.com.produto.model.ProdutoEntity;
import br.com.produto.repository.ProdutoRepository;
import br.com.produto.resource.ResourceProduto;
import br.com.produto.response.ProdutoListResponse;
import br.com.produto.response.ProdutoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    @Autowired
    private ResourceProduto resourceProduto;
    
    ObjectMapper objectMapper;
    
    public List<ProdutoListResponse> findAllProduto(){
        List<ProdutoEntity> produtosEntity = repository.findAll();
        List<ProdutoListResponse> produtoListResponse = produtosEntity.stream()
                .map(produtoEntity -> resourceProduto.getLinkListAllProduto(produtoEntity))
                .collect(Collectors.toList());
        return produtoListResponse;
    }
    
    public ProdutoResponse findProduto(Long id){
        Optional<ProdutoEntity> produtoEntity = repository.findById(id);
        ProdutoResponse produtoResponse = resourceProduto.addLinkFindProduto(produtoEntity.get());
        return produtoResponse;
    }
    
    public ProdutoEntity saveProduto(ProdutoEntity produtoEntity){
        return repository.save(produtoEntity);
    }
    
    public ProdutoResponse updateProduto(Long id, ProdutoEntity produto){
        produto.setId(id);
        ProdutoResponse produtoResponse = resourceProduto.addLinkUpdate(id, repository.save(produto));
        return produtoResponse;
    }
    
    public ProdutoEntity delteProduto(Long id){
        repository.deleteById(id);
        return new ProdutoEntity();
    }
    
}
