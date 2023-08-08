package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {
    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> percentage) {

        List<Chocolate> chocolates;

        if (percentage.isPresent()) {
            chocolates = chocolateService.findChocolateByPercentage(percentage.get());
        } else {
            chocolates = chocolateService.getAllChocolates();
        }

        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable int Id) { // Path Variable must match the route mapping
        Optional<Chocolate> chocolate = chocolateService.getChocolateById((long) Id);
        if (chocolate.isPresent()) {
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
