package wrt.group.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import wrt.group.demo.dto.ClusterDto;
import wrt.group.demo.dto.PolygonPointDto;
import wrt.group.demo.entity.Cluster;
import wrt.group.demo.entity.PolygonPoint;
import wrt.group.demo.entity.USM;
import wrt.group.demo.entity.Users;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClusterRepository {
    @PersistenceContext
    private EntityManager em;
    private UserRepository userRepository;
    public ClusterRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(ClusterDto clusterDto) {

        String companyId = clusterDto.getCompanyId();
        String username = clusterDto.getUsername();

        Users user = userRepository.findByUsername(companyId);
        String clusterName = clusterDto.getClusterName();
        List<PolygonPointDto> polygonDtoList = clusterDto.getPolygonList();

        List<PolygonPoint> polygonList = polygonDtoList.stream()
                .map(dto -> {
                    PolygonPoint polygon = new PolygonPoint(dto.getUsmId(), dto.getX(), dto.getY());

                    // 필요한 다른 속성들을 복사
                    return polygon;
                })
                .collect(Collectors.toList());


        Cluster cluster = Cluster.builder()
                .user(user)
                .clusterName(clusterName)
                .polygonList(polygonList)
                .build();

        em.persist(cluster);
    }

    public List<Long> findLastClusterId () {

        String jpqlGetId = "SELECT c.id FROM Cluster c ORDER BY c.id DESC";

        Long getId = em.createQuery(jpqlGetId, Long.class)
                .setMaxResults(1)
                .getSingleResult();

        String jpqlUSMList = "SELECT p.usmId FROM Cluster c join c.polygonList p WHERE c.id = :getId";

        return em.createQuery(jpqlUSMList, Long.class)
                        .setParameter("getId", getId)
                        .getResultList();




    }

}
