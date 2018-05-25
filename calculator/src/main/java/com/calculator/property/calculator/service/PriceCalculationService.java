package com.calculator.property.calculator.service;

import com.calculator.property.calculator.model.PriceCalculation;
import com.calculator.property.calculator.model.PropertyPrice;
import com.calculator.property.calculator.repository.PriceCalculationRepository;
import com.calculator.property.calculator.repository.PropertyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

    @Autowired
    PriceCalculationRepository priceCalculationRepository;

    @Autowired
    PropertyPriceRepository propertyPriceRepository;

    public double distance(double latitude1, double longitude1, double latitude2, double longitude2) {

        int R = 6371;

        double latDistance = Math.toRadians(latitude1 - latitude2);
        double longDistance = Math.toRadians(longitude1 - longitude2);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(latitude2)) *
                        Math.cos(Math.toRadians(latitude1)) *
                        Math.sin(longDistance / 2) *
                        Math.sin(longDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    public double closestProperty(PriceCalculation priceCalculation) {
        List<PropertyPrice> properties = propertyPriceRepository.findAll();
        PropertyPrice closestProperty = null;
        double closestdistance = Double.MAX_VALUE;
        for (PropertyPrice property : properties) {
            double distance = distance(property.getLatitude(), property.getLongitude(), priceCalculation.getLatitude(), priceCalculation.getLongitude());
            if (closestdistance > distance) {
                closestdistance = distance;
                closestProperty = property;
            }
        }

        double price = closestProperty.getAveragePropertyPrices() * priceCalculation.getSquareMeter();
        priceCalculation.setCalculatedPrice(price);
        priceCalculationRepository.save(priceCalculation);
        return priceCalculation.getCalculatedPrice();

    }

    public double creat(String lat, String longi, String sq) {
        double latitude = Double.parseDouble(lat);
        double longitude = Double.parseDouble(longi);
        double squareMeter = Double.parseDouble(sq);
        double price = closestProperty(new PriceCalculation(latitude, longitude, squareMeter));
        return  price;
    }


}
