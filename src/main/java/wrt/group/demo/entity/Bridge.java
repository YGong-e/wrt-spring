package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Bridge {

    @Id @GeneratedValue
    private Long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USM_ID")
    private USM usm;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLUSTER_ID")
    private Cluster cluster;

}
