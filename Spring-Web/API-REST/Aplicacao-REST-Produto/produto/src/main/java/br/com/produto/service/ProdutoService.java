package br.com.produto.service;

import br.com.produto.model.Produto;
import br.com.produto.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    public List<Produto> findAllProduto(){
        return repository.findAll();
    }
    
    public Produto findProduto(Long id){
        return repository.findById(id).get();
    }
    
    public Produto saveProduto(Produto produto){
        return repository.save(produto);
    }
    
    public Produto updateProduto(Long id, Produto produto){
        produto.setId(id);
        return repository.save(produto);
    }
    
    public Produto delteProduto(Long id){
        repository.deleteById(id);
        return new Produto();
    }
}
