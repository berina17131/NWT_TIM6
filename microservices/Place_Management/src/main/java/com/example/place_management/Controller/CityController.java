package com.example.place_management.Controller;

import com.example.place_management.Model.City;
import com.example.place_management.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public City getById(@PathVariable("id") String id) {
        Optional cityHelp = cityRepository.findById(Integer.parseInt(id));
        City city = (City) cityHelp.get();

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

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteAll() {
        cityRepository.deleteAll();

        return "All cities deleted";
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        cityRepository.deleteById(Integer.parseInt(id));

        return "City with id=" + id + " deleted";
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.POST)
    public String postByName(@PathVariable("name") String name) {
        City city = new City(name);
        cityRepository.save(city);

        return "City with name " + name + " saved successfully";
    }
    
    @RequestMapping(value="/id/{id}/newName/{newName}", method = RequestMethod.PUT)
    public String putById(@PathVariable("id") String id, @PathVariable("newName") String newName) {
        Optional cityHelp = cityRepository.findById(Integer.parseInt(id));
        City city = (City) cityHelp.get();
        String oldName = city.getName();
        city.setName(newName);
        cityRepository.save(city);

        return "City with old name " + oldName  + " saved successfully as " + newName;
    }

    @RequestMapping(value="/oldName/{oldName}/newName/{newName}", method = RequestMethod.PUT)
    public String putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {
        City city = null;
        for (City cityHelp : cityRepository.findAll()) {
            if(cityHelp.getName().equals(oldName))
                city = cityHelp;
        }
        city.setName(newName);
        cityRepository.save(city);

        return "City with old name " + oldName  + " saved successfully as " + newName;
    }
}