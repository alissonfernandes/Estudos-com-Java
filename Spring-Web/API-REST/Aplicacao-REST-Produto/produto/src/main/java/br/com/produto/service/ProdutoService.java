package br.com.produto.service;

import br.com.produto.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    public List<Produto> findAllProduto(){
        List<Produto> produtos = new ArrayList<>();
        
        produtos.add(new Produto(1L, "Bermuda", "Bermuda Masculina M"));
        produtos.add(new Produto(2L, "Camiseta", "Camiseta Feminina P"));
        
        return produtos;
    }
    
    public Produto findProduto(Long id){
        return new Produto(id, "Bermuda", "Bermuda Masculina M");
    }
    
    public void saveProduto(Produto produto){
    }
    
    public void updateProduto(Long id, Produto produto){
    }
    
    public void delteProduto(Long id){
    }
}
