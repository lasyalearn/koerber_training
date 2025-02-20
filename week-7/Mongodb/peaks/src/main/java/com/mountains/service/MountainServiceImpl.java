package com.mountains.service.impl;

import com.mountains.dao.MountainDao;
import com.mountains.dto.Mountains;
import com.mountains.service.MountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MountainServiceImpl implements MountainService {

    @Autowired
    private MountainDao mountainDao;

    @Override
    public List<Mountains> findAll() {
        return mountainDao.findAll();
    }

    @Override
    public Mountains findByName(String name) {
        return mountainDao.findByName(name);
    }

    @Override
    public List<Mountains> findByNameNot(String name) {
        return mountainDao.findByNameNot(name);
    }

    @Override
    public List<Mountains> findByHeightGreaterThan(int height) {
        return mountainDao.findByHeightGreaterThan(height);
    }

    @Override
    public List<Mountains> findByNameAndHeightGreaterThan(String name, int height) {
        return mountainDao.findByNameAndHeightGreaterThan(name, height);
    }

    @Override
    public List<Mountains> findByNameOrHeightGreaterThan(String name, int height) {
        return mountainDao.findByNameOrHeightGreaterThan(name, height);
    }

    @Override
    public List<Mountains> findByLocation(String location) {
        return mountainDao.findByLocation(location);
    }

    @Override
    public List<Mountains> findByLocationIn(List<String> locations) {
        return mountainDao.findByLocationIn(locations);
    }

    @Override
    public List<Mountains> findByAscentsTotalGreaterThan(int ascents) {
        return mountainDao.findByAscentsTotalGreaterThan(ascents);
    }

    @Override
    public List<Mountains> findByAscentsFirstWinterYearGreaterThan(int year) {
        return mountainDao.findByAscentsFirstWinterYearGreaterThan(year);
    }

    @Override
    public List<Mountains> findAllExcludingAscentsAndLocation() {
        return mountainDao.findAllExcludingAscentsAndLocation();
    }

    @Override
    public List<Mountains> findFirstThreeMountains(Pageable pageable) {
        return mountainDao.findTop3By(pageable);
    }
}
