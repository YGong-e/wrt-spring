package wrt.group.demo.repository;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import wrt.group.demo.dto.UserDto;
import wrt.group.demo.entity.Users;

import java.util.List;

@Repository
public class USMRepository {

    @PersistenceContext
    private EntityManager em;

    public List<String> findUSMPolygon() {
        return em.createQuery("select m.id, m.latitude, m.longitude from USM m", String.class)
                .getResultList();
    }


}
