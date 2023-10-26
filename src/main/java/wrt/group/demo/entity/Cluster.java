package wrt.group.demo.entity;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "cluster")
    private List<Bridge> bridegeList = new ArrayList<>();
    private String clusterEquip;
    private List<String> polygonList;
    private String indexUSM;

    private String clusterName;
}
