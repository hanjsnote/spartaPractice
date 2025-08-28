package org.example;

import jakarta.persistence.*;
import org.example.entity.Company;
import org.example.entity.Period;
import org.example.entity.Tutor;

import java.util.List;

public class ProjectionMain {
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

            List<Tutor> tutorList = em.createQuery("select t from Tutor t", Tutor.class).getResultList();

            Tutor wonuk = tutorList.get(0);
            wonuk.setName("wonuk2");

            // 실제로는 다른 방식을 사용한다. -> 묵시적 JOIN
            Company company = em.createQuery("select t.company from Tutor t", Company.class).getSingleResult();

            // join을 명시적으로 사용 -> 명시적 JOIN
            Company companyV2 = em.createQuery("select t from Tutor t join t.company", Company.class).getSingleResult();

            // Embedded
//            em.createQuery("select t.period from Tutor t", Period.class).getResultList();

            // Scala
            // 반환 타입 Object
//            List resultList = em.createQuery("select t.name, t.age from Tutor t").getResultList();
//
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[1] = " + result[1]);

            // 반환 타입 Object[]
//            List<Object[]> resultList = em.createQuery("select t.name, t.age from Tutor t").getResultList();
//
//            Object[] result = resultList.get(0);
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[1] = " + result[1]);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
