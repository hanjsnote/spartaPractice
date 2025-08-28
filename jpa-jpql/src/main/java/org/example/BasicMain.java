package org.example;

import jakarta.persistence.*;
import org.example.entity.Tutor;

import java.util.List;

public class BasicMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {

            Tutor tutor = new Tutor("wonuk", 100);
            em.persist(tutor);

            // TypeQuery
            TypedQuery<Tutor> typeQuery1 = em.createQuery("select t from Tutor t", Tutor.class);
            TypedQuery<String> typeQuery2 = em.createQuery("select t.name from Tutor t", String.class);

            // Query
            Query query = em.createQuery("select t.name, t.age from Tutor t");

            // result
            List resultList = em.createQuery("select t.name, t.age from Tutor t").getResultList();
            Tutor singleResult = em.createQuery("select t from Tutor t where t.id = 1L", Tutor.class).getSingleResult();

            // parameter binding
            Tutor wonuk = em.createQuery("select t from Tutor t where t.name = :name", Tutor.class)
                    .setParameter("name", "wonuk")
                    .getSingleResult();
            System.out.println("wonuk.getName() = " + wonuk.getName());
            System.out.println("wonuk.getAge() = " + wonuk.getAge());
            // 사용하지 않는다.
//            Tutor wonuk2 = em.createQuery("select t from Tutor t where t.age = ?1", Tutor.class)
//                    .setParameter(1, 100)
//                    .getSingleResult();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}