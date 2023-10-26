package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class USM {

    @Id
    @GeneratedValue
    @Column(name = "USM_ID")
    private Long id;


    @OneToMany(mappedBy = "usm")
    private List<Bridge> bridegeList = new ArrayList<>();

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
