package wrt.group.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class FilterDto {

    private String username;

    private String companyId;

    private String clusterName;

    private List<Object> polygonList = new ArrayList<>();

}
