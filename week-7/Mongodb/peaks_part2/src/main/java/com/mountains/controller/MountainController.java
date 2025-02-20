package com.mountains.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mountains.dao.MountainDao;
import com.mountains.dto.Mountains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mountains")
public class MountainController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MountainDao mountainDao;
    @GetMapping("/")
    public List<Mountains> getAllMountains() {
        return mountainDao.findAll();
    }

    // Get a mountain by name
    @GetMapping("/{name}")
    public String getMountainByName(@PathVariable String name) {
        try {
            Mountains mountain = mountainDao.findByName(name);
            return objectMapper.writeValueAsString(mountain);  // Serialize mountain to JSON
        } catch (Exception e) {
            return "Error serializing mountain: " + e.getMessage();
        }
    }

    // Get mountains where name is not equal to the given name
    @GetMapping("/not/{name}")
    public String getMountainsNotByName(@PathVariable String name) {
        try {
            List<Mountains> mountains = mountainDao.findByNameNot(name);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Get mountains taller than a given height
    @GetMapping("/height/greater/{height}")
    public String getMountainsByHeight(@PathVariable int height) {
        try {
            List<Mountains> mountains = mountainDao.findByHeightGreaterThan(height);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Get mountains by name and taller than a given height
    @GetMapping(" ") 
    public String getMountainsByNameAndHeight(@RequestParam String name, @RequestParam int height) {
        try {
            List<Mountains> mountains = mountainDao.findByNameAndHeightGreaterThan(name, height);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Get mountains by name or taller than a given height
    @GetMapping("/name-or-height")
    public String getMountainsByNameOrHeight(@RequestParam String name, @RequestParam int height) {
        try {
            List<Mountains> mountains = mountainDao.findByNameOrHeightGreaterThan(name, height);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Get mountains by location
    @GetMapping("/location/{location}")
    public String getMountainsByLocation(@PathVariable String location) {
        try {
            List<Mountains> mountains = mountainDao.findByLocation(location);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Get mountains by multiple locations
    @PostMapping("/locations")
    public String getMountainsByLocations(@RequestBody List<String> locations) {
        try {
            List<Mountains> mountains = mountainDao.findByLocationIn(locations);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Get mountains where total ascents are greater than a given value
    @GetMapping("/ascents/greater/{ascents}")
    public String getMountainsByAscents(@PathVariable int ascents) {
        try {
            List<Mountains> mountains = mountainDao.findByAscentsTotalGreaterThan(ascents);
            return objectMapper.writeValueAsString(mountains);  // Serialize list to JSON
        } catch (Exception e) {
            return "Error serializing mountains: " + e.getMessage();
        }
    }

    // Add a new mountain
    @PostMapping("/")
    public String addMountain(@RequestBody Mountains mountain) {
        try {
            Mountains savedMountain = mountainDao.save(mountain);
            return objectMapper.writeValueAsString(savedMountain);  // Serialize the saved mountain to JSON
        } catch (Exception e) {
            return "Error saving mountain: " + e.getMessage();
        }
    }

    // Delete a mountain by ID
    @DeleteMapping("/{id}")
    public String deleteMountain(@PathVariable String id) {
        try {
            mountainDao.deleteById(id);
            return "Mountain with ID " + id + " has been deleted";
        } catch (Exception e) {
            return "Error deleting mountain: " + e.getMessage();
        }
    }
}
