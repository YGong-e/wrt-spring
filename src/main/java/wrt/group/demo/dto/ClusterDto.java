package wrt.group.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ClusterDto {

    private String username;

    private String companyId;

    private String clusterName;

    private List<Long> polygonList = new ArrayList<>();
}