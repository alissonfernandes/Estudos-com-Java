package br.com.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClassePrincipal {
    
    // Buscando dados no banco de dados
    public static void main(String[] args) {
        
        // SQL - Nativo
        
        // Trazendo somente um resultado
        System.out.println("\t" + selectSingleSQL());
        // Trazendo uma lista de resultados
        selectResultListSQL().forEach(pessoa -> System.out.println("\t" + pessoa));
        
        
        // JPQL
        
        // Trazendo somente um resultado
        System.out.println("\t" + selectSingleJPQL());
        // Trazendo uma lista de resultados
        selectResultListJPQL().forEach(pessoa -> System.out.println("\t" + pessoa)); 
    }
    
    // SQL - Nativo
    public static Pessoa selectSingleSQL(){
       String nome = "Marcos";
       String sql = "SELECT * FROM pessoa WHERE nome = :nome";
        
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       Pessoa pessoa = (Pessoa) entityManager.createNativeQuery(sql, Pessoa.class).
               setParameter("nome", nome).
               getSingleResult();
       
       entityManager.close();
       entityManagerFactory.close();
       
       return pessoa;
    }
    
    // SQL - Nativo
    public static List<Pessoa> selectResultListSQL(){
       String sql = "SELECT * FROM pessoa";
        
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       List<Pessoa> pessoas = entityManager.createNativeQuery(sql, Pessoa.class).
               getResultList();
       
       entityManager.close();
       entityManagerFactory.close();
       
       return pessoas;
    }
    
    // JPQL - Trazendo somente um resultado
    public static Pessoa selectSingleJPQL(){
       String nome = "Marcos";
       String sql = "SELECT p FROM Pessoa p WHERE p.nome = :nome";
        
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       Pessoa pessoa = entityManager.createQuery(sql, Pessoa.class).
            setParameter("nome", nome).
            getSingleResult();
       
       entityManager.close();
       entityManagerFactory.close();
       
       return pessoa;
    }
    
    // JPQL - Trazendo uma lista de resustados
    public static List<Pessoa> selectResultListJPQL(){
       String sql = "SELECT p FROM Pessoa p WHERE p.estado = :estado";
        
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate.localhost");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       List<Pessoa> pessoas = entityManager.createQuery(sql, Pessoa.class).
               setParameter("estado", entityManager.find(Estado.class, 1)).
               getResultList();
       
       entityManager.close();
       entityManagerFactory.close();
       
       return pessoas;
    }
}
