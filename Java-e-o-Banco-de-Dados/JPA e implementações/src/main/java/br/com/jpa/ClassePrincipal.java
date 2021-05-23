package br.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClassePrincipal {
    public static void main(String[] args) {
        
       Estado estado = new Estado("MG", "Minas Gerais");
       Pessoa pessoa = new Pessoa("Rodrigo", 21, "Masc", estado);
       
       insert(pessoa, estado);
       
       
    }
    
    // Inserir objeto ao banco de dados
    public static void insert(Pessoa pessoa, Estado estado){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       entityManager.getTransaction().begin();
       
       entityManager.persist(estado);
       entityManager.persist(pessoa);
       
       entityManager.getTransaction().commit();
       
       entityManager.close();
       entityManagerFactory.close();
    }
}
