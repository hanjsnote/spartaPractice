package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Tutor;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            Tutor tutor = new Tutor("js");
            em.persist(tutor);

            // 영속성 컨텍스트 초기화
            em.flush();
            em.clear();

            // em.find()
//             Tutor findTutor = em.find(Tutor.class, tutor.getId());

            // Proxy 객체 조회
//            Tutor proxyTutor = em.getReference(Tutor.class, tutor.getId());
//            System.out.println("proxyTutor.getName() = " + proxyTutor.getName());
//            System.out.println("proxyTutor.getClass() = " + proxyTutor.getClass());

            // LazyInitializationException
//            Tutor proxyTutor = em.getReference(Tutor.class, tutor.getId());
//            System.out.println("proxyTutor.getClass() = " + proxyTutor.getClass());

            // 준영속 상태
//            em.detach(proxyTutor);
//
//            proxyTutor.getName();

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