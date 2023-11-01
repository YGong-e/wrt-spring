package wrt.group.demo.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
public class PolygonPointDto {
    private Long usmId;
    private Float x;
    private Float y;

    public PolygonPointDto(Long usmId, Float x, Float y) {
        this.usmId = usmId;
        this.x = x;
        this.y = y;
    }
}
