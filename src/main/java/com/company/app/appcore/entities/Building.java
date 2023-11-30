package com.company.app.appcore.entities;

import com.company.app.appcore.util.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = Constants.TABLE_PREFIX + "BUILDINGS")
public class Building implements Serializable {

    @Id
    private String buildingId;

    @Column(unique = true)
    private String buildingName;

    @Column
    private String streetName;

    @Column
    private String streetNumber;

    @Column
    private String municipality;
    @Column
    private String zipCode;
    @Column
    private String county;

    @Column
    private String longitude;
    @Column
    private String latitude;

    @Column
    private int numberOfFloors = 1;

    @Column
    private ZonedDateTime creationDate;

    public Building() {
    }

    public Building(String buildingId, String buildingName, String streetName, String streetNumber, String municipality, String zipCode, String county, String longitude, String latitude, int numberOfFloors, ZonedDateTime creationDate) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.municipality = municipality;
        this.zipCode = zipCode;
        this.county = county;
        this.longitude = longitude;
        this.latitude = latitude;
        this.numberOfFloors = numberOfFloors;
        this.creationDate = creationDate;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Building{");
        sb.append("buildingId='").append(buildingId).append('\'');
        sb.append(", buildingName='").append(buildingName).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", streetNumber='").append(streetNumber).append('\'');
        sb.append(", municipality='").append(municipality).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", county='").append(county).append('\'');
        sb.append(", longitude='").append(longitude).append('\'');
        sb.append(", latitude='").append(latitude).append('\'');
        sb.append(", numberOfFloors=").append(numberOfFloors);
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
