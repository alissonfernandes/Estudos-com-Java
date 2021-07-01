package br.com.produto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "produto")
public class ProdutoEntity  extends RepresentationModel<ProdutoEntity>{
    
    @Id
    private Long id;
    
    @Column
    private String nome;
    
    @Column
    private String descricao;
    
    @Column
    private float preco = 0f;
    
    @Column
    private int estoque = 0;
    
    public ProdutoEntity(){}

    public ProdutoEntity(Long id, String nome, String descricao, float preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
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
