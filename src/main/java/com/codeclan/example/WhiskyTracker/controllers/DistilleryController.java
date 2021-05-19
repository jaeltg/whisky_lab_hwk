package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;


    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> findDistilleryFiltered(
            @RequestParam(name="region", required = false)
                    String region,
            @RequestParam(name="whiskiesAge", required = false)
                    Integer whiskiesAge

    ){
        if(region != null){
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        if(whiskiesAge != null){
            return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(whiskiesAge), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

}
