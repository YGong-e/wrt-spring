package wrt.group.demo.dto;


import lombok.Data;
import wrt.group.demo.entity.Cluster;
import wrt.group.demo.entity.USM;

@Data
public class BridgeDto {

    private USM usm;

    private Cluster cluster;
}
