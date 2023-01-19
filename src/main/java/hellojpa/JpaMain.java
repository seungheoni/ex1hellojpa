package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("micle");

            Member member2 = new Member();
            member2.setUsername("seongheon");

            Member member3 = new Member();
            member3.setUsername("gildong");

            Member member4 = new Member();
            member4.setUsername("gildong");

            Member member5 = new Member();
            member5.setUsername("gildong");


            System.out.println("===================");
            em.persist(member);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);
            System.out.println("member.getId() :" + member.getId());
            System.out.println("member2.getId() :" + member2.getId());
            System.out.println("member3.getId() :" + member3.getId());
            System.out.println("member4.getId() :" + member4.getId());
            System.out.println("member5.getId() :" + member5.getId());
            System.out.println("===================");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }



    }
}
