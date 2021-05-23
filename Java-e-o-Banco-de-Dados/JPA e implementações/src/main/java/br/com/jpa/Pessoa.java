package br.com.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private int idade;
    
    @Column
    private String sexo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;
    
    public Pessoa(){}

    public Pessoa(String nome, int idade, String sexo, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", estado=" + estado + '}';
    }

   
}