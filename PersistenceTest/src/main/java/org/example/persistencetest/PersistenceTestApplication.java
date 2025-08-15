package org.example.persistencetest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.persistencetest.entity.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersistenceTestApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(PersistenceTestApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        System.out.println("=== 1. 비영속 상태 ===");
        Member member = new Member("홍길동");
        System.out.println(member); // id=null, name='홍길동'

        System.out.println("\n=== 2. 영속 상태 ===");
        em.persist(member);
        System.out.println(member); // id=1, name='홍길동'

        System.out.println("\n=== 3. 조회 - 1차 캐시 확인 ===");
        Member find1 = em.find(Member.class, member.getId());
        Member find2 = em.find(Member.class, member.getId());
        System.out.println("find1 == find2 ? " + (find1 == find2)); // true

        System.out.println("\n=== 4. 변경 감지 (Dirty Checking) ===");
        find1.setName("임꺽정");
        System.out.println("find1: " + find1); //find1: id=1, name='임꺽정'
        System.out.println("find2: " + find2); //find2: id=1, name='임꺽정'

        System.out.println("\n=== 5. 삭제 후 조회 ===");
        Member beforDelete = em.find(Member.class, member.getId());
        em.remove(beforDelete);
        System.out.println("beforDelete 조회 결과: " + beforDelete); // beforDelete 조회 결과: id=1, name='임꺽정'

        Member afterDelete = em.find(Member.class, member.getId());
        System.out.println("afterDelete 조회 결과: " + afterDelete); // afterDelete 조회 결과: null
    }
}



