package com.calculator.property.calculator.model;

import javax.validation.constraints.NotEmpty;

public class NewProperty {

    private String latitude;

    private String longitude;

    private String squareMeter;

    public NewProperty() {
    }

    public NewProperty(String latitude, String longitude, String squareMeter) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.squareMeter = squareMeter;
    }

    @Override
    public String toString() {
        return "NewProperty{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", squareMeter='" + squareMeter + '\'' +
                '}';
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(String squareMeter) {
        this.squareMeter = squareMeter;
    }
}
