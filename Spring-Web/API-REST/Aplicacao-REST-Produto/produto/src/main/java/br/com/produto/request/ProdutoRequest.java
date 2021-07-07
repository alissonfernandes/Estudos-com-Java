package br.com.produto.request;

public class ProdutoRequest {
    private Long id;
    
    public ProdutoRequest(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
