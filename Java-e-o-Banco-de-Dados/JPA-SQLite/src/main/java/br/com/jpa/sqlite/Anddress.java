package br.com.jpa.sqlite;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "anddress")
public class Anddress {
    
    @Column(name = "id_anddress")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "cidade_anddress")
    private String cidade;
    
    @Column(name = "bairro_anddress")
    private String bairro;
    
    @Column(name = "rua_anddress")
    private String rua;
    
    @Column(name = "numero_anddress")
    private int numero;
    
    @Column(name = "complemento_anddress")
    private String complemento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private State estado;
    
    @OneToMany(mappedBy = "endereco",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    
    private List<User> users = new ArrayList<>();
    
    public Anddress(){}
    
    public Anddress(String cidade, String bairro, String rua, int numero, String complemento, State estado) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
    }

    public Anddress(int id, String cidade, String bairro, String rua, int numero, String complemento, State estado) {
        this.id = id;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public State getEstado() {
        return estado;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Anddress{" + "id=" + id + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", estado=" + estado + '}';
    }
}