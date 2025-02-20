package com.mountains.dao;

import com.mountains.dto.Mountains;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MountainDao extends MongoRepository<Mountains, String>
{
    public List<Mountains> findAll();
    public Mountains findByName(String name);
    public List<Mountains> findByNameNot(String name);
    public List<Mountains> findByHeightGreaterThan(int height);
    @Query("{'name': ?0, 'height': ?1}")
    public List<Mountains> findByNameAndHeightGreaterThan(String name, int height);
    @Query("{'$or': [{'name': ?0}, {'height': ?1}]}")
    public List<Mountains> findByNameOrHeightGreaterThan(String name, int height);
    public List<Mountains> findByLocation(String location);
    @Query("{'location': {$in: ?0}}")
    public List<Mountains> findByLocationIn(List<String> locations);

    public List<Mountains> findByAscentsTotalGreaterThan(int ascents);

}
