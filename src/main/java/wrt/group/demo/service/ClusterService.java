package wrt.group.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wrt.group.demo.dto.ClusterDto;
import wrt.group.demo.dto.FilterDto;
import wrt.group.demo.dto.PolygonPointDto;
import wrt.group.demo.entity.Users;

import wrt.group.demo.model.PolygonMapper;
import wrt.group.demo.repository.ClusterRepository;
import wrt.group.demo.repository.USMRepository;
import wrt.group.demo.repository.UserRepository;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
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
        String username = filterDto.getUsername();
        String clusterName = filterDto.getClusterName();
        String companyId = filterDto.getCompanyId();
       //ObjectMapper
        List<PolygonMapper> polygonList = filterDto.getPolygonList();
        Long userIndex = userRepository.getUserIndex(companyId);
        System.out.println("polygonList = " + polygonList);
        List<Float> DtoPolygonList = new ArrayList<>();

        //만든 ObjectMapper를 다시 리스트로 만들어 각각 변수로 뺴기 -> DtoPolygonList로 만들기
        for (PolygonMapper point : polygonList) {

            Float x = point.getX();
            Float y = point.getY();
            DtoPolygonList.add(x);
            DtoPolygonList.add(y);

        }
        System.out.println("DtoPolygonList = " + DtoPolygonList);

        Float x1 = DtoPolygonList.get(0);
        Float y1 = DtoPolygonList.get(1);
        Float x2 = DtoPolygonList.get(2);
        Float y2 = DtoPolygonList.get(3);
        System.out.println("y2 = " + y2);


        //USM 리스트 에서 폴리곤이랑 ID값 받아오기
        List<Object[]> usmPolygonList = usmRepository.findUSMPolygon();
        System.out.println("usmPolygonList = " + usmPolygonList);

        //filterPolygonList 만들기
        List<PolygonPointDto> filterPolygonList = new ArrayList<>();
        //필터링 작업
        for (Object[] polygonObj : usmPolygonList) {
            Long id = (Long) polygonObj[0];
            Float longitude = (Float) polygonObj[1];
            Float latitude = (Float) polygonObj[2];

            if( longitude >= x1 && longitude <=x2 && latitude >=y1 && latitude <=y2)
            {
                filterPolygonList.add(new PolygonPointDto(id,longitude, latitude));
            }
        }

        System.out.println("filterPolygonList = " + filterPolygonList);

        clusterDto.setCompanyId(companyId);
        clusterDto.setUsername(username);
        clusterDto.setClusterName(clusterName);
        clusterDto.setPolygonList(filterPolygonList);

        clusterRepository.save(clusterDto);

    }
}
