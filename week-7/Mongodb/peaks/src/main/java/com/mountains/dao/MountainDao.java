package com.mountains.dao;

import com.mountains.dto.Mountains;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable; // Correct import

import java.util.List;

@Repository
public interface MountainDao extends MongoRepository<Mountains, String> {

    List<Mountains> findAll();
    Mountains findByName(String name);
    List<Mountains> findByNameNot(String name);
    List<Mountains> findByHeightGreaterThan(int height);

    @Query("{'name': ?0, 'height': {$gt: ?1}}") // Fixed query
    List<Mountains> findByNameAndHeightGreaterThan(String name, int height);

    @Query("{'$or': [{'name': ?0}, {'height': {$gt: ?1}}]}") // Fixed height condition
    List<Mountains> findByNameOrHeightGreaterThan(String name, int height);

    List<Mountains> findByLocation(String location);

    @Query("{'location': {$in: ?0}}")
    List<Mountains> findByLocationIn(List<String> locations);

    List<Mountains> findByAscentsTotalGreaterThan(int ascents);

    // 5. Find mountains first ascended in winter after the year 2000
    @Query("{'ascents.first_winter.year': {$gt:?0}}")
    List<Mountains> findByAscentsFirstWinterYearGreaterThan(int year);

    // 6. Exclude ascents and location fields
    @Query(value = "{}", fields = "{'ascents': 0, 'location': 0}")
    List<Mountains> findAllExcludingAscentsAndLocation();

    // 7. Retrieve only three mountain peaks
    List<Mountains> findTop3By(Pageable pageable);
}
