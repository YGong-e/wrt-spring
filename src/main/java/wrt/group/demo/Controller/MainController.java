package wrt.group.demo.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wrt.group.demo.dto.FilterDto;
import wrt.group.demo.entity.USM;
import wrt.group.demo.service.ClusterService;
import wrt.group.demo.service.USMService;
import wrt.group.demo.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@Validated
public class MainController {

        private final UserService userService;
        private final ClusterService clusterService;

        private final USMService usmService;
        private final FilterDto filterDto;

    public MainController(UserService userService, ClusterService clusterService, USMService usmService, FilterDto filterDto) {
        this.userService = userService;
        this.clusterService = clusterService;
        this.usmService = usmService;
        this.filterDto = filterDto;
    }

    @PostMapping(value = "/filter", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
        public ResponseEntity<String> registFilter(@Valid @RequestBody FilterDto filterDto) {
            System.out.println("filterDto = " + filterDto);
         userService.register(filterDto);
         clusterService.register(filterDto);
         List<USM> usmList = usmService.findInsertResultLogic();

//        USM usm = usmService.findInsertResultLogic();

            return new ResponseEntity(usmList, HttpStatus.OK);
        }


}
