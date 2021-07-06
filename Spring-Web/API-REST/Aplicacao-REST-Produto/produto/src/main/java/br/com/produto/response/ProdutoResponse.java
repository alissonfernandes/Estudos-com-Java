package br.com.produto.response;

import br.com.produto.model.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class ProdutoResponse extends RepresentationModel<ProdutoEntity>{
    private Long id;
    private String nome;
    private String descricao;
    private float preco;
    private int estoque;
    
    public ProdutoResponse(ProdutoEntity p){
        this.id = p.getId();
        this.nome = p.getNome();
        this.descricao = p.getDescricao();
        this.preco = p.getPreco();
        this.estoque = p.getEstoque();
    }
    
    public ProdutoResponse(){}

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
