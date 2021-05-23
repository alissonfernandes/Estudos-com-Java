package br.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClassePrincipal {
    public static void main(String[] args) {
        
       delete(1);
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
    
    // Selecionar dados no banco de dados
    public static void select(int id){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       Pessoa pessoa = entityManager.find(Pessoa.class, id);
       System.out.println(pessoa.toString());
       
       entityManager.close();
       entityManagerFactory.close();
    }
    
    // Realizar update
    public static void update(int id){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       Pessoa pessoa = entityManager.find(Pessoa.class, id);
       
       entityManager.getTransaction().begin();
       
       pessoa.setNome("Fernando");
       pessoa.setSexo("Masc");
       pessoa.setIdade(22);
       
       entityManager.getTransaction().commit();
       
       entityManager.close();
       entityManagerFactory.close();
    }
    
    // Remover pessoa do banco de dados
    public static void delete(int id){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       Pessoa pessoa = entityManager.find(Pessoa.class, id);
       
       entityManager.getTransaction().begin();
       
       entityManager.remove(pessoa);
       
       entityManager.getTransaction().commit();
       
       entityManager.close();
       entityManagerFactory.close();
    }
    
}
