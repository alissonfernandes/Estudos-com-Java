package br.com.produto.dto;

import br.com.produto.model.ProdutoEntity;
import java.io.Serializable;

public class Produto implements Serializable{
    
    private Long id;
    private String nome;
    private String descricao;
    private float preco;
    private int estoque;

    public Produto(ProdutoEntity produtoEntity) {
        this.id = produtoEntity.getId();
        this.nome = produtoEntity.getNome();
        this.descricao = produtoEntity.getDescricao();
        this.preco = produtoEntity.getPreco();
        this.estoque = produtoEntity.getEstoque();
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

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", estoque=" + estoque + '}';
    }
    
}
