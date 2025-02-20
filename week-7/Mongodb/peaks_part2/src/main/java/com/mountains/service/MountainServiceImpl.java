package com.mountains.service;

import com.mountains.dao.MountainDao;
import com.mountains.dto.Mountains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MountainServiceImpl implements MountainService
{
    private MountainDao dao;

    @Autowired
    public MountainServiceImpl(MountainDao dao)
    {
        this.dao = dao;
    }
    @Override
    public List<Mountains> findAll()
    {
        return dao.findAll();
    }
    @Override
    public Mountains findByName(String name)
    {
        return dao.findByName(name);
    }

    @Override
    public List<Mountains> findByNameNot(String name)
    {
        return dao.findByNameNot(name);
    }

    @Override
    public List<Mountains> findByHeightGreaterThan(int height)
    {
        return dao.findByHeightGreaterThan(height);
    }

    @Override
    public List<Mountains> findByNameAndHeightGreaterThan(String name, int height)
    {
        return dao.findByNameAndHeightGreaterThan(name, height);
    }

    @Override
    public List<Mountains> findByNameOrHeightGreaterThan(String name, int height)
    {
        return dao.findByNameOrHeightGreaterThan(name, height);
    }

    @Override
    public List<Mountains> findByLocation(String location)
    {
        return dao.findByLocation(location);
    }

    @Override
    public List<Mountains> findByLocationIn(List<String> locations)
    {
        return dao.findByLocationIn(locations);
    }

    @Override
    public List<Mountains> findByAscentsTotalGreaterThan(int ascents)
    {
        return dao.findByAscentsTotalGreaterThan(ascents);
    }
}
