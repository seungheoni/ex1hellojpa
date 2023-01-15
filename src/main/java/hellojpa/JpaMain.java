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
            //추가
            /*Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);*/

            //조회
            /*Member member = em.find(Member.class, 1L);
            System.out.println("findMember.id ="+member.getId());
            System.out.println("findMember.name ="+member.getName());*/

            //수정
//            Member member = em.find(Member.class, 1L);
//            member.setName("seongheon");

            //jpql
//            List<Member> memberList = em.createQuery("select m from Member as m",Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();


            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJpa");

            //영속
//            System.out.println("===BEFORE===");
//            em.persist(member);
//            System.out.println("===AFTER===");
//
//            Member member1 = em.find(Member.class, 101L);
//
//            System.out.println("id:"+member1.getId()+" name:" + member.getName());

            //영속상태에서의 1차 캐시, 쓰기지연 sql 저장소
//            Member member = em.find(Member.class, 101L);
//            Member member2 = em.find(Member.class, 101L);

            Member member = new Member(155L,"A");
            Member member2 = new Member(165L,"B");

            em.persist(member);
            System.out.println("================================");
            em.persist(member2);

            //준영속
/*            em.detach(member2);
            em.detach(member);
            em.clear();*/

            //트랜잭션 커밋
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }



    }
}
