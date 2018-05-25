package com.calculator.property.calculator.util;

import com.calculator.property.calculator.model.PropertyPrice;
import com.calculator.property.calculator.repository.PriceCalculationRepository;
import com.calculator.property.calculator.repository.PropertyPriceRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(PropertyPriceRepository propertyPriceRepository) {


        propertyPriceRepository.save(new PropertyPrice(47.49507047785717, 19.029334502563415, 460000));
        propertyPriceRepository.save(new PropertyPrice(47.49762205580582, 19.005130248413025, 430000));
        propertyPriceRepository.save(new PropertyPrice(47.50442744739763, 19.068108145414044, 410000));
        propertyPriceRepository.save(new PropertyPrice(47.50442744739763, 19.068108145414044, 410000));
        propertyPriceRepository.save(new PropertyPrice(47.51836003248163, 19.053211212158203, 470000));

    }
}
