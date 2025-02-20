package com.mountains.service;

import com.mountains.dto.Mountains;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MountainService
{
    public List<Mountains> findAll();
    public Mountains findByName(String name);
    public List<Mountains> findByNameNot(String name);
    public List<Mountains> findByHeightGreaterThan(int height);
    public List<Mountains> findByNameAndHeightGreaterThan(String name, int height);
    public List<Mountains> findByNameOrHeightGreaterThan(String name, int height);
    public List<Mountains> findByLocation(String location);
    public List<Mountains> findByLocationIn(List<String> locations);
    public List<Mountains> findByAscentsTotalGreaterThan(int ascents);
}
