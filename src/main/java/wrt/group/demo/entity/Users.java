package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;
    private String username;
    private String companyId;

    @Builder
    public Users(String username, String companyId) {
        this.username = username;
        this.companyId = companyId;
    }
}
