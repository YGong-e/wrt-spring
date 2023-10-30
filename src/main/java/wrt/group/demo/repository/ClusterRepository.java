package wrt.group.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClusterRepository {

    @PersistenceContext
    private EntityManager em;


}
