package br.com.jpa.sqlite;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "state")
public class State {
    
    @Column(name = "id_state")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name_state")
    private String name;
    
    @Column(name = "uf_state")
    private String uf;
    
    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    
    private List<Anddress> anddress = new ArrayList<>();
    
    public State(){}
    
    public State(String name, String uf) {
        this.name = name;
        this.uf = uf;
    }

    public State(int id, String name, String uf) {
        this.id = id;
        this.name = name;
        this.uf = uf;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "State{" + "id=" + id + ", name=" + name + ", uf=" + uf + '}';
    }
}