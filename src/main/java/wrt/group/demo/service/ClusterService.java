package wrt.group.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wrt.group.demo.dto.ClusterDto;
import wrt.group.demo.dto.FilterDto;
import wrt.group.demo.entity.Users;
import wrt.group.demo.repository.ClusterRepository;
import wrt.group.demo.repository.USMRepository;
import wrt.group.demo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClusterService {

    private final ClusterRepository clusterRepository;
    private final ClusterDto clusterDto;
    private final USMRepository usmRepository;
    private final UserRepository userRepository;

    @Transactional
    public void register(FilterDto filterDto) {
        String companyId = filterDto.getCompanyId();
        System.out.println("companyId!!!!!!!! = " + companyId);
        Long userIndex = userRepository.getUserIndex(companyId);

        List<String> usmPolygonList = usmRepository.findUSMPolygon();

        System.out.println("usmPolygonList = " + usmPolygonList);


    }
}
