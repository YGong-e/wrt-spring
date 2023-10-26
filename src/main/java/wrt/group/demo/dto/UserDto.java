package wrt.group.demo.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDto {
    private String username;
    private String companyId;
}
