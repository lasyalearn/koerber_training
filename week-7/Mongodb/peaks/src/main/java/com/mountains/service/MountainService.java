package com.mountains.service;

import com.mountains.dto.Mountains;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MountainService {
    List<Mountains> findAll();
    Mountains findByName(String name);
    List<Mountains> findByNameNot(String name);
    List<Mountains> findByHeightGreaterThan(int height);
    List<Mountains> findByNameAndHeightGreaterThan(String name, int height);
    List<Mountains> findByNameOrHeightGreaterThan(String name, int height);
    List<Mountains> findByLocation(String location);
    List<Mountains> findByLocationIn(List<String> locations);
    List<Mountains> findByAscentsTotalGreaterThan(int ascents);
    List<Mountains> findByAscentsFirstWinterYearGreaterThan(int year);
    List<Mountains> findAllExcludingAscentsAndLocation();
    List<Mountains> findFirstThreeMountains(Pageable pageable);
}
