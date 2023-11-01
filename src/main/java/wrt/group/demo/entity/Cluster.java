package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Cluster {

    @Id
    @GeneratedValue
    @Column(name = "CLUSTER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Users user;

    private String clusterName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CLUSTER_ID")
    private List<PolygonPoint> polygonList = new ArrayList<>();



    //    @OneToMany(mappedBy = "cluster")
//    private List<Bridge> bridegeList = new ArrayList<>();
//    private String clusterEquip;

    @Builder
    public Cluster(Users user, String clusterName , List<PolygonPoint> polygonList) {
        this.user = user;
        this.clusterName = clusterName;
        this.polygonList = polygonList;
    }
}
