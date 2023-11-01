package wrt.group.demo.repository;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import wrt.group.demo.dto.PolygonPointDto;

import java.util.List;

@Repository
public class USMRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Object[]> findUSMPolygon() {
        return em.createQuery("select m.id usmId, m.longitude, m.latitude  from USM m", Object[].class)
                .getResultList();
    }


}
