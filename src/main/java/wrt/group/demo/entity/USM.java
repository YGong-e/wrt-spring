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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USM_ID")
    private Long id;

    private Long gnbId;
    private String cuNetwork;
    private Long cuId;
    private String cuName;
    private Long duId;
    private String duName;
    private String duVer;
    private String duIp;
    private String userLabel;
    private Float latitude;
    private Float longitude;
    private Long cellId;
    private String tac;
    private Long pci;


}
