package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Tutor;

import java.util.ArrayList;
import java.util.List;

public class FunctionMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            Tutor tutor = new Tutor("wonuk", 100);
            em.persist(tutor);

            ArrayList<String> resultList = new ArrayList<>();

            String concatQuery = "select concat(t.name, ' is good') from Tutor t";
            List<String> concatResult = em.createQuery(concatQuery, String.class).getResultList();
            resultList.add(concatResult.get(0));

            String substringQuery = "select substring(t.name, 2, 3) from Tutor t";
            List<String> substringResult = em.createQuery(substringQuery, String.class).getResultList();
            resultList.add(substringResult.get(0));

            Tutor tutor2 = new Tutor(" wonukgap ", 101);
            em.persist(tutor2);

            String trimQuery = "select trim(t.name) from Tutor t";
            List<String> trimResult = em.createQuery(trimQuery, String.class).getResultList();
            resultList.add(trimResult.get(1));

            String upperQuery = "select upper(t.name) from Tutor t";
            List<String> upperResult = em.createQuery(upperQuery, String.class).getResultList();
            resultList.add(upperResult.get(0));

            String lengthQuery = "select length(t.name) from Tutor t";
            List<Integer> lengthResult = em.createQuery(lengthQuery, Integer.class).getResultList();
            resultList.add(lengthResult.get(0).toString());

            for (String result : resultList) {
                System.out.println("result = " + result);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
