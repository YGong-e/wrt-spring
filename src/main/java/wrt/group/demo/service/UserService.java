package wrt.group.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wrt.group.demo.dto.FilterDto;
import wrt.group.demo.dto.UserDto;
import wrt.group.demo.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDto userDto;

    @Transactional
    public void register(FilterDto filterDto) {
        System.out.println("filterDto = " + filterDto);

        String username = filterDto.getUsername();
        String companyId = filterDto.getCompanyId();

        System.out.println("companyId = " + companyId);

        userDto.setUsername(username);
        userDto.setCompanyId(companyId);

        userRepository.save(userDto);
    }
}
