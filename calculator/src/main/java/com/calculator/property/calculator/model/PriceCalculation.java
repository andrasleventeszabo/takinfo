package com.calculator.property.calculator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class PriceCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "latitude can not be empty.")
    private double latitude;

    @NotEmpty(message = "longitude can not be empty.")
    private double longitude;

    @NotEmpty(message = "square meter can not be empty")
    private double squareMeter;

    @NotEmpty(message = "calculated Price can not be empty")
    private double calculatedPrice;

    public PriceCalculation() {
    }

    public PriceCalculation(@NotEmpty(message = "latitude can not be empty.") double latitude, @NotEmpty(message = "longitude can not be empty.") double longitude, @NotEmpty(message = "square meter can not be empty") double squareMeter) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.squareMeter = squareMeter;
    }
}
