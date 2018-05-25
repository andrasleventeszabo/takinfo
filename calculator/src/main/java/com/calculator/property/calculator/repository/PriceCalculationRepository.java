package com.calculator.property.calculator.repository;


import com.calculator.property.calculator.model.PriceCalculation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceCalculationRepository  extends JpaRepository<PriceCalculation, Long>{
    @Override
    List<PriceCalculation> findAll();

    @Override
    PriceCalculation getOne(Long aLong);

//    PriceCalculation
}
