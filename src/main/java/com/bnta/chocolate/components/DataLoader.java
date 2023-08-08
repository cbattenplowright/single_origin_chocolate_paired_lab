package com.bnta.chocolate.components;

import com.bnta.chocolate.ChocolateApplication;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    ChocolateRepository chocolateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate est1 = new Estate("Cadbury", "Jamaica");
        Estate est2 = new Estate("Mondelez", "Barbados");
        Estate est3 = new Estate("The Rabot Estate", "St Lucia");
        Estate est4 = new Estate("Quesnel", "Trindad");
        Estate est5 = new Estate("Figeroux", "Trinidad");
        Estate est6 = new Estate("Nestle", "Ghana");

        estateRepository.saveAll(Arrays.asList(est1,est2,est3,est4,est5,est6));

        Chocolate choc1 = new Chocolate("Dairy Milk", 53, est1);
        Chocolate choc2 = new Chocolate("Twix", 49, est2);
        Chocolate choc3 = new Chocolate("KitKat", 45, est3);
        Chocolate choc4 = new Chocolate("Snickers", 41, est4);
        Chocolate choc5 = new Chocolate("Mars", 37, est5);
        Chocolate choc6 = new Chocolate("Milky Bar", 20, est6);
        Chocolate choc7 = new Chocolate("Double Decker", 70, est5);

        chocolateRepository.saveAll(Arrays.asList(choc1,choc2,choc3, choc4, choc5, choc6, choc7));
    }
}
