package com.calculator.property.calculator.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class PropertyPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double latitude;

    private double longitude;

    private double averagePropertyPrices;

    public PropertyPrice() {
    }

    public PropertyPrice(double latitude, double longitude,double averagePropertyPrices) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.averagePropertyPrices = averagePropertyPrices;
    }
}
