package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cluster {

    @Id
    @GeneratedValue
    @Column(name = "CLUSTER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "cluster")
    private List<USM> usmList = new ArrayList<>();
    private String clusterEquip;
    private List<String> polygonList;
    private String indexUSM;
}
