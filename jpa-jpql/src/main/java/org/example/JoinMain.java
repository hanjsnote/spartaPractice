package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Company;
import org.example.entity.Subject;
import org.example.entity.Tutor;

import java.util.List;

public class JoinMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            Subject subject = new Subject("spring");
            em.persist(subject);

            Tutor tutor = new Tutor("spring", 100);
            em.persist(tutor);

            // 영속성 컨텍스트 초기화
            em.flush();
            em.clear();

            String query = "select t from Tutor t left join Subject s on t.name = s.name";
            List<Tutor> tutorList = em.createQuery(query, Tutor.class).getResultList();
            Tutor findTutor = tutorList.get(0);
            System.out.println("findTutor.getAge() = " + findTutor.getAge());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
