package br.com.produto.rest;

import br.com.produto.model.ProdutoEntity;
import br.com.produto.response.ProdutoResponse;
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
    public ResponseEntity<List<ProdutoEntity>> getAllProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAllProduto());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getProduto(@PathVariable Long id){
        ProdutoResponse produtoResponse = produtoService.findProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }
    
    @PostMapping("/")
    public ResponseEntity setProduto(@RequestBody ProdutoEntity produtoEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produtoEntity));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateProduto(@PathVariable Long id, @RequestBody ProdutoEntity produto){
        return ResponseEntity.ok(produtoService.updateProduto(id, produto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduto(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produtoService.delteProduto(id));
    }
            
}
