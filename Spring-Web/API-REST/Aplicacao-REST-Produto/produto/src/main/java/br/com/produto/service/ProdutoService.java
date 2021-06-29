package br.com.produto.service;

import br.com.produto.model.ProdutoEntity;
import br.com.produto.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    ObjectMapper objectMapper;
    
    public List<ProdutoEntity> findAllProduto(){
        List<ProdutoEntity> produtos = repository.findAll();
        /*List<ProdutoDto> produtosDto = produtos.stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoDto.class))
                .collect(Collectors.toList());
         repository.findAll().forEach((p) -> {objectMapper.convertValue(p, ProdutoDto.class);});*/
        return produtos;
    }
    
    public ProdutoEntity findProduto(Long id){
        return repository.findById(id).get();
    }
    
    public ProdutoEntity saveProduto(ProdutoEntity produto){
        return repository.save(produto);
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
