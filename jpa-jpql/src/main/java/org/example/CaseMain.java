package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Tutor;

import java.util.List;

public class CaseMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            Tutor tutor = new Tutor("wonuk", 100);
            em.persist(tutor);

            // 영속성 컨텍스트 초기화
            em.flush();
            em.clear();

            String query =
                    "select" +
                            " case when t.age < 10 then '어린이'" +
                            " when t.age >= 80 then '노약자'" +
                            " else '청년'" +
                            " end " +
                    "from Tutor t";
            List<String> resultList = em.createQuery(query, String.class).getResultList();

            for (String range : resultList) {
                System.out.println("range = " + range);
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
