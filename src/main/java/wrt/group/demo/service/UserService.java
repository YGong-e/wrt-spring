package wrt.group.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wrt.group.demo.dto.FilterDto;
import wrt.group.demo.dto.UserDto;
import wrt.group.demo.repository.USMRepository;
import wrt.group.demo.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDto userDto;
    private final USMRepository usmRepository;


    @Transactional
    public void register(FilterDto filterDto) {
        List<String> companyIdList = userRepository.findCompanyID();

        String username = filterDto.getUsername();
        String companyId = filterDto.getCompanyId();
        String clusterName = filterDto.getClusterName();

        // 이미 user가 존재할 경우 사용자 추가 X
        if(companyIdList.contains(companyId)) {
            System.out.println("do not update users entity");

        }
        else {
//            filterDto.getPolygonList();
            userDto.setUsername(username);
            userDto.setCompanyId(companyId);
            userRepository.save(userDto);
        }
    }
}
