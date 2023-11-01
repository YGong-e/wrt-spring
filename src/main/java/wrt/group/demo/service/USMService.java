package wrt.group.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wrt.group.demo.entity.PolygonPoint;
import wrt.group.demo.entity.USM;
import wrt.group.demo.repository.ClusterRepository;
import wrt.group.demo.repository.USMRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class USMService {

    private final USMRepository usmRepository;
    private final ClusterRepository clusterRepository;

    @Transactional
    public List<USM> findInsertResultLogic () {
    List<Long> USMList = clusterRepository.findLastClusterId();

    List<USM> usmList = usmRepository.findUSMList(USMList);

    return usmList;

    }
}
