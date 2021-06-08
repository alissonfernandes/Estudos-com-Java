package br.com.springwebmvc.model;

import javax.validation.constraints.NotBlank;

public class Pessoa {
   
    @NotBlank
    private String nome;
    
    @NotBlank
    private String idade;

    public Pessoa(final String nome, final int idade) {
        this.nome = nome;
        this.idade = Integer.toString(idade);
    }
    
    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(final String idade) {
        this.idade = idade;
    }
}