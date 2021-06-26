package br.com.produto.rest;

import br.com.produto.model.Produto;
import br.com.produto.service.ProdutoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoResource {
    
    private ProdutoService produtoService;
    
    public ProdutoResource(ProdutoService produtoService){
        this.produtoService = produtoService;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Produto>> getAllProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAllProduto());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findProduto(id));
    }
    
    @PostMapping("/")
    public ResponseEntity setProduto(@RequestBody Produto produto){
        produtoService.saveProduto(produto);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateProduto(@PathVariable Long id, @RequestBody Produto produto){
        produtoService.updateProduto(id, produto);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduto(@PathVariable Long id){
        produtoService.delteProduto(id);
        return ResponseEntity.ok().build();
    }
            
}