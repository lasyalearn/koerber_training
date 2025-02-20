package com.mountains.controller;

import com.mountains.dto.Mountains;
import com.mountains.service.MountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mountains")
public class MountainController {

    @Autowired
    private MountainService mountainService;

    // 1. Get all mountains
    @GetMapping("/all")
    public List<Mountains> getAllMountains() {
        return mountainService.findAll();
    }

    // 2. Get mountain by name
    @GetMapping("/name/{name}")
    public Mountains getMountainByName(@PathVariable String name) {
        return mountainService.findByName(name);
    }

    // 3. Get mountains excluding a specific name
    @GetMapping("/name/not/{name}")
    public List<Mountains> getMountainsByNameNot(@PathVariable String name) {
        return mountainService.findByNameNot(name);
    }

    // 4. Get mountains taller than a given height
    @GetMapping("/height/greater/{height}")
    public List<Mountains> getMountainsByHeightGreaterThan(@PathVariable int height) {
        return mountainService.findByHeightGreaterThan(height);
    }

    // 5. Get mountains by name and height greater than a value
    @GetMapping("/name/{name}/height/greater/{height}")
    public List<Mountains> getMountainsByNameAndHeightGreaterThan(@PathVariable String name, @PathVariable int height) {
        return mountainService.findByNameAndHeightGreaterThan(name, height);
    }

    // 6. Get mountains by name or height greater than a value
    @GetMapping("/name/{name}/or/height/greater/{height}")
    public List<Mountains> getMountainsByNameOrHeightGreaterThan(@PathVariable String name, @PathVariable int height) {
        return mountainService.findByNameOrHeightGreaterThan(name, height);
    }

    // 7. Get mountains by location
    @GetMapping("/location/{location}")
    public List<Mountains> getMountainsByLocation(@PathVariable String location) {
        return mountainService.findByLocation(location);
    }

    // 8. Get mountains by multiple locations
    @PostMapping("/locations")
    public List<Mountains> getMountainsByLocations(@RequestBody List<String> locations) {
        return mountainService.findByLocationIn(locations);
    }

    // 9. Get mountains with ascent total greater than a given number
    @GetMapping("/ascents/greater/{ascents}")
    public List<Mountains> getMountainsByAscentsTotalGreaterThan(@PathVariable int ascents) {
        return mountainService.findByAscentsTotalGreaterThan(ascents);
    }

    // 10. Get mountains first ascended in winter after the year 2000
    @GetMapping("/first-winter-after/{year}")
    public List<Mountains> getMountainsFirstAscendedInWinterAfter(@PathVariable int year) {
        return mountainService.findByAscentsFirstWinterYearGreaterThan(year);
    }

    // 11. Get mountains excluding ascents and location fields
    @GetMapping("/exclude/ascents-location")
    public List<Mountains> getMountainsExcludingAscentsAndLocation() {
        return mountainService.findAllExcludingAscentsAndLocation();
    }

    // 12. Get first three mountain peaks
    @GetMapping("/top3")
    public List<Mountains> getFirstThreeMountains() {
        return mountainService.findFirstThreeMountains(PageRequest.of(0, 3));
    }
}
