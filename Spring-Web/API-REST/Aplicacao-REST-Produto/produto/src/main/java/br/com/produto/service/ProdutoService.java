package br.com.produto.service;

import br.com.produto.dto.Produto;
import br.com.produto.model.ProdutoEntity;
import br.com.produto.repository.ProdutoRepository;
import br.com.produto.request.ProdutoRequest;
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
    
    @Autowired
    private ObjectMapper objectMapper;
    
    public List<ProdutoListResponse> findAllProduto(){
        List<ProdutoEntity> produtosEntity = repository.findAll();
        List<ProdutoListResponse> produtoListResponse = produtosEntity.stream()
                .map(produtoEntity -> resourceProduto.getLinkListAllProduto(produtoEntity))
                .collect(Collectors.toList());
        return produtoListResponse;
    }
    
    public ProdutoResponse findProduto(ProdutoRequest produtoRequest){
        Optional<ProdutoEntity> produtoEntity = repository.findById(produtoRequest.getId());
        ProdutoResponse produtoResponse = resourceProduto.addLinkFindProduto(produtoEntity.get());
        return produtoResponse;
    }
    
    public ProdutoEntity saveProduto(Produto produtoDto){
        ProdutoEntity produtoEntity = objectMapper.convertValue(produtoDto, ProdutoEntity.class);
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
