package com.example.place_management.Controller;


import com.example.place_management.Model.City;
import com.example.place_management.Repository.CityRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;

    @Autowired
    CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public City test(@RequestParam(value = "id") String id) {

        Optional citya = cityRepository.findById(Integer.parseInt(id));
        City city = (City) citya.get();
        //city.add((City) citya.get());

        return city;
    }
}