package br.com.jpa.sqlite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name_user")
    private String name;
    
    
    @Column(name = "idade_user")
    private int idade;
    
    @Column(name = "sexo_user")
    private String sexo;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Anddress endereco;
    
    public User(){}

    public User(int id, String name, int idade, String sexo, Anddress endereco) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
    }
    
    public User(String name, int idade, String sexo, Anddress endereco) {
        this.name = name;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Anddress getEndereco() {
        return endereco;
    }

    public void setEndereco(Anddress endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", idade=" + idade + ", sexo=" + sexo + ", endereco=" + endereco + '}';
    }
}
