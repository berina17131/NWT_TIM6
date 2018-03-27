package com.example.place_management.Controller;

import com.example.place_management.Model.City;
import com.example.place_management.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;

    @Autowired
    CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

<<<<<<< HEAD
    @RequestMapping(method = RequestMethod.GET)
    public City test(@RequestParam(value = "id") String id) {

        Optional citya = cityRepository.findById(Integer.parseInt(id));
        City city = (City) citya.get();
        System.out.println(city);
        //city.add((City) citya.get());
=======
    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public City getById(@PathVariable("id") String id) {
        Optional cityHelp = cityRepository.findById(Integer.parseInt(id));
        City city = (City) cityHelp.get();
>>>>>>> refs/remotes/origin/master

        return city;
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public City getByName(@PathVariable("name") String name) {
        for (City city : cityRepository.findAll()) {
            if(city.getName().equals(name))
                return city;
        }

        return null;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        cityRepository.deleteById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postById(City city) {
        cityRepository.save(city);

        return "OK";
    }
}