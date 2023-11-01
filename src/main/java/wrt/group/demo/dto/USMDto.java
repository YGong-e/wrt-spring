package wrt.group.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class USMDto {

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
