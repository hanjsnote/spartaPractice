package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Tutor;

import java.util.List;

public class PagingMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            for (int i = 0; i < 30; i++) {
                Tutor tutor = new Tutor("wonuk" + i, i);
                em.persist(tutor);
            }

            // 영속성 컨텍스트 초기화
            em.flush();
            em.clear();

            List<Tutor> tutorList = em.createQuery("select t from Tutor t order by t.age desc", Tutor.class)
                    .setFirstResult(5)
                    .setMaxResults(10)
                    .getResultList();

            for (Tutor tutor : tutorList) {
                System.out.println("tutor = " + tutor.getId() + ", " + tutor.getName() + ", " + tutor.getAge());
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
