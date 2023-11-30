package com.company.app.appcore.services;

import com.company.app.appcore.entities.Building;

import java.util.List;

public interface BuildingService {

    Building retrieveBuilding(String buildingId) throws Exception;

    List<Building> retrieveBuildings();

    Building addBuilding(String buildingName, String streetName, String streetNumber, String municipality, String zipCode, String county, Integer numOfFloors);

    void deleteBuilding(String buildingId);
}
