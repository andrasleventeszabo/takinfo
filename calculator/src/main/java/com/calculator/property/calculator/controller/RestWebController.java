package com.calculator.property.calculator.controller;

import com.calculator.property.calculator.model.PropertyPrice;
import com.calculator.property.calculator.repository.PriceCalculationRepository;
import com.calculator.property.calculator.repository.PropertyPriceRepository;
import com.calculator.property.calculator.service.PriceCalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class RestWebController {


    private final PriceCalculationRepository priceCalculationRepository;
    private final PropertyPriceRepository propertyPriceRepository;
    private final PriceCalculationService priceCalculationService;


    public RestWebController(PriceCalculationRepository priceCalculationRepository, PropertyPriceRepository propertyPriceRepository, PriceCalculationService priceCalculationService) {
        this.priceCalculationRepository = priceCalculationRepository;
        this.propertyPriceRepository = propertyPriceRepository;
        this.priceCalculationService = priceCalculationService;
    }

    @GetMapping("/find-all")
    public List<PropertyPrice> propertyPrices(){
        return propertyPriceRepository.findAll();
    }

    @PostMapping("/calculation/new")
    public ResponseEntity<?> newCalculation(@RequestParam Map<String,String> allRequestParams){
        double price = priceCalculationService.creat(allRequestParams.get("latitude"),
                allRequestParams.get("longitude"),
                allRequestParams.get("squeremeter"));


        return ResponseEntity.ok(price);
    }


}
