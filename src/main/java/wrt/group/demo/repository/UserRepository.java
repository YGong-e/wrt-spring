package wrt.group.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import wrt.group.demo.dto.UserDto;
import wrt.group.demo.entity.Users;

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

}
