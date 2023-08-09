package com.bnta.chocolate.models;

import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChocolateDTO {

    @Autowired
    Chocolate chocolate;

    @Autowired
    EstateRepository estateRepository;
    private Estate estate;

    public ChocolateDTO(String name, int cocoaPercentage, int estateId){
        chocolate = new Chocolate();
        chocolate.setName(name);
        chocolate.setCocoaPercentage(cocoaPercentage);
        chocolate.setCocoaPercentage(cocoaPercentage);
        estate = estateRepository.getById(Long.valueOf(estateId));
        chocolate.setEstate(estate);
    }

    public Chocolate returnChocolate() {
        return chocolate;
    }

}
