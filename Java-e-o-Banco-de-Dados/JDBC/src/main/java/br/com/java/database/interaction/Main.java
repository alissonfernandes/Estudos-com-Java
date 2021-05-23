package br.com.java.database.interaction;

import java.sql.Connection;

public class Main {
    
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Usuário", 0, "sexo");
        
        pessoa.insert();
        pessoa.select(1);
        pessoa.update(1);
        pessoa.delete(0);
    }
}
