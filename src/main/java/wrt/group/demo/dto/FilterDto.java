package wrt.group.demo.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FilterDto {

    private String username;

    private String companyId;

    private String clusterName;

    private List<Long> polygonList = new ArrayList<>();

    @Builder
    public FilterDto(String username, String companyId, String clusterName, List<Long> polygonList) {
        this.username = username;
        this.companyId = companyId;
        this.clusterName = clusterName;
        this.polygonList = polygonList;
    }
}
