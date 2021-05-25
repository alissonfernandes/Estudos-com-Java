package br.com.jpa.sqlite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClassePrincipal {
    
    
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sqlite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        State state = new State("Minas Gerais", "MG");
        Anddress anddress = new Anddress("Belo Horizonte", "Centro", "Oscar Pereira Barbosa UDD", -1, " ", state);
        User user = new User("Ruan Renan", 25, "Masc", anddress);
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(state);
        entityManager.persist(anddress);
        entityManager.persist(user);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
