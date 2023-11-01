package wrt.group.demo.repository;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import wrt.group.demo.dto.PolygonPointDto;
import wrt.group.demo.dto.USMDto;
import wrt.group.demo.entity.USM;

import java.util.List;

@Repository
public class USMRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Object[]> findUSMPolygon() {
        return em.createQuery("select m.id usmId, m.longitude, m.latitude  from USM m", Object[].class)
                .getResultList();
    }

    public List<USM> findUSMList(List<Long> clusterId) {
        String jpql = "SELECT u FROM USM u WHERE u.id IN (:clusterId)";
        return (List<USM>) em.createQuery(jpql, USM.class)
                .setParameter("clusterId", clusterId)
                .getResultList();
    }


}
