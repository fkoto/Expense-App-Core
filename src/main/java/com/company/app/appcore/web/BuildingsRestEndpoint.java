package com.company.app.appcore.web;

import com.company.app.appcore.services.BuildingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.app.appcore.entities.Building;

import java.util.List;
import java.util.Optional;

@RestController("buildingsRestEndpoint")
@RequestMapping(path = "/buildings", produces = "application/json")
public class BuildingsRestEndpoint {

    @Autowired
    private BuildingService service;

    @GetMapping("/")
    public ResponseEntity<List<Building>> retrieveBuildings(){
        return ResponseEntity.of(Optional.ofNullable(service.retrieveBuildings()));
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<Building> retrieveBuildingById(@PathVariable String buildingId) throws Exception {
        return ResponseEntity.of(Optional.ofNullable(service.retrieveBuilding(buildingId)));
    }

    @DeleteMapping("/{buildingId}")
    public void deleteBuilding(@PathVariable String buildingId){
        service.deleteBuilding(buildingId);
    }

    @PostMapping("/")
    public ResponseEntity<Building> createBuilding(@RequestParam(name = "buildingName",required = false) String buildingName,
                                                   @RequestParam("streetName") String streetName,@RequestParam("streetNumber") String streetNumber,
                                                   @RequestParam("municipality") String municipality, @RequestParam("zipCode") String zipCode,
                                                   @RequestParam("county") String county, @RequestParam(name = "floors", required = false) Integer numOfFloors){
        Building createdBuilding = service.addBuilding(buildingName, streetName,  streetNumber,  municipality,  zipCode,  county,  numOfFloors);

        return ResponseEntity.of(Optional.ofNullable(createdBuilding));
    }
}
