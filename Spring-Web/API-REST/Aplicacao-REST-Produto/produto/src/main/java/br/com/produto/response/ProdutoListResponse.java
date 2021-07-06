package br.com.produto.response;

import br.com.produto.model.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class ProdutoListResponse extends RepresentationModel<ProdutoEntity>{
    private Long id;
    private String nome;
    private float preco;
    
    @JsonProperty("id")
    public Long getId() {
        return id;
    }
    @JsonProperty("id")
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
