package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class USM {

    @Id
    @GeneratedValue
    @Column(name = "USM_ID")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLUSTER_ID")
    private Cluster cluster;
    private Long gnbId;
    private String cuNetwork;
    private Long cuId;
    private String cuName;
    private Long duId;
    private String duName;
    private String duVer;
    private String duIp;
    private String userLabel;
    private Long latitude;
    private Long longitude;
    private Long cellId;
    private String tac;
    private Long pci;


}
