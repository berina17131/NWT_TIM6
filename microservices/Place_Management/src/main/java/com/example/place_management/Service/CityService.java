package com.example.place_management.Service;

import com.example.place_management.Model.City;
import com.example.place_management.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City getById(String id) {
        Optional cityHelp = cityRepository.findById(Integer.parseInt(id));
        City city = (City) cityHelp.get();

        return city;
    }

    public City getByName(String name) {
        for (City city : cityRepository.findAll()) {
            if(city.getName().equals(name))
                return city;
        }

        return null;
    }

    public String deleteAll() {
        cityRepository.deleteAll();

        return "All cities deleted";
    }

    public String deleteById(String id) {
        cityRepository.deleteById(Integer.parseInt(id));

        return "City with id=" + id + " deleted";
    }

    public String postByName(String name) {
        City city = new City(name);
        cityRepository.save(city);

        return "City with name " + name + " saved successfully";
    }

    public String putById(String id, String newName) {
        Optional cityHelp = cityRepository.findById(Integer.parseInt(id));
        City city = (City) cityHelp.get();
        String oldName = city.getName();
        city.setName(newName);
        cityRepository.save(city);

        return "City with old name " + oldName  + " saved successfully as " + newName;
    }

    public String putByName(String oldName, String newName) {
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