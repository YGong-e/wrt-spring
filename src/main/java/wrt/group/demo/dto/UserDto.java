package wrt.group.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class UserDto {

    private final String username;

    private final String companyId;

    private final String clusterName;

    private final List<Long> polygonList = new ArrayList<>();

}
