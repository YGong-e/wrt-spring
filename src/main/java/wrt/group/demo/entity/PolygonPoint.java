package wrt.group.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PolygonPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long usmId;

    private Float x;

    private Float y;

    public PolygonPoint(Long usmId, Float x, Float y) {
        this.usmId = usmId;
        this.x = x;
        this.y = y;
    }
}


