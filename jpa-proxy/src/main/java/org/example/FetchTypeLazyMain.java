package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Company;
import org.example.entity.Tutor;

public class FetchTypeLazyMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            Company company = new Company("sparta");
            em.persist(company);

            Tutor tutor = new Tutor("js");
            tutor.setCompany(company);
            em.persist(tutor);

            // 영속성 컨텍스트 초기화
            em.flush();
            em.clear();

            // em.find()
            Tutor findTutor = em.find(Tutor.class, tutor.getId());

            // getCompany()
            System.out.println("findTutor.getCompany().getClass() = " + findTutor.getCompany().getClass());

            // getCompany().getName()
            System.out.println("findTutor.getCompany().getName() = " + findTutor.getCompany().getName());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
