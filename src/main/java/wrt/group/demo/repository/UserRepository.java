package wrt.group.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;
import wrt.group.demo.dto.UserDto;
import wrt.group.demo.entity.Users;

import java.util.List;

@Slf4j
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;


    public void save(UserDto userDto) {

        String username = userDto.getUsername();
        String companyId = userDto.getCompanyId();

        Users user = Users.builder()
                .username(username)
                .companyId(companyId)
                .build();

        System.out.println("user = " + user);

         em.persist(user);

        }

    public List<String> findCompanyID() {
        return em.createQuery("select m.companyId from Users m", String.class)
                .getResultList();
    }

        public Long getUserIndex(String companyId) {
            System.out.println("직접 받아온 companyId = " + companyId);

            String jpql = "select m.id from Users m where m.companyId = :companyId";

            Long userIndex = (Long) em.createQuery(jpql)
                    .setParameter("companyId", companyId)
                    .getSingleResult();

            System.out.println("userIndex = " + userIndex);
             return userIndex;
        }

    public Users findByUsername(String companyId) {

        String jpql = "select m from Users m where m.companyId = :companyId";

        return em.createQuery(jpql, Users.class)
                .setParameter("companyId", companyId)
                .getSingleResult();

    }

}
