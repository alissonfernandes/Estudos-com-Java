package br.com.java.database.interaction;

public  abstract class AbstractPessoa {
    
    protected int id;
    protected String nome;
    protected int idade;
    protected String sexo;
    
    public AbstractPessoa(){}

    public AbstractPessoa(String nome, int idade, String sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    public abstract void insert();
    public abstract void select(int id);
    public abstract void update(int id);
    public abstract void delete( int id);

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
        return "AbstractPessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + '}';
    }
    
}
