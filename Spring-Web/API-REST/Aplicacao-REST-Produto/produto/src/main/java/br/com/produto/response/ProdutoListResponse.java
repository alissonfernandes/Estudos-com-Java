package br.com.produto.response;

import br.com.produto.model.ProdutoEntity;
import org.springframework.hateoas.RepresentationModel;

public class ProdutoListResponse extends RepresentationModel<ProdutoListResponse>{
    private Long id;
    private String nome;
    private float preco;

    public ProdutoListResponse(ProdutoEntity produtoEntity) {
        this.id = produtoEntity.getId();
        this.nome = produtoEntity.getNome();
        this.preco = produtoEntity.getPreco();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
