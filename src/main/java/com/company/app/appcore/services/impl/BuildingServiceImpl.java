package com.company.app.appcore.services.impl;

import com.company.app.appcore.entities.Building;
import com.company.app.appcore.repositories.BuildingsRepository;
import com.company.app.appcore.services.BuildingService;
import com.company.app.appcore.util.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service("buildings")
public class BuildingServiceImpl implements BuildingService {
    private static Logger log = LoggerFactory.getLogger(BuildingServiceImpl.class);

    @Autowired
    private BuildingsRepository repository;

    @Autowired
    private IdGenerator generator;


    @Override
    public Building retrieveBuilding(String buildingId) throws Exception {
        if (buildingId == null || buildingId.trim().isBlank()){
            throw new Exception("Unsupported Input");
        }

        Building retrievedBuilding = repository.findById(buildingId).orElse(null);

        if (retrievedBuilding == null){
            throw new Exception("Building Not Found");
        }

        return retrievedBuilding;
    }

    @Override
    public List<Building> retrieveBuildings() {
        return repository.findAll();
    }

    @Override
    public Building addBuilding(String buildingName, String streetName, String streetNumber,
                                String municipality, String zipCode, String county, Integer numOfFloors) {
        // check input...

        Building build = new Building();

        build.setBuildingId(generator.generateKey());
        build.setBuildingName((buildingName == null || buildingName.trim().isBlank())?
                generateBuildingName(build.getBuildingId()) : buildingName.trim());
        build.setStreetName(streetName);
        build.setStreetNumber(streetNumber);
        build.setMunicipality(municipality);
        build.setCounty(county);
        build.setZipCode(zipCode);
        if (numOfFloors != null && numOfFloors > 0){
            build.setNumberOfFloors(numOfFloors);
        }

        build.setCreationDate(ZonedDateTime.now());

        log.info("Created building: {}", build);
        repository.save(build);
        return build;
    }

    @Override
    public void deleteBuilding(String buildingId) {
        repository.deleteById(buildingId);
    }

    private String generateBuildingName(String buildingId){
        return buildingId;
    }
}
