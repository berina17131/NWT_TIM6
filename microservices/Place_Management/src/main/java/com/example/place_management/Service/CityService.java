package com.example.place_management.Service;

import com.example.place_management.Model.City;
import com.example.place_management.Repository.CityRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() throws ServiceException {
        try {
            return cityRepository.findAll();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot fetch all cities.");
        }
    }

    public City getById(String id) throws ServiceException {
        try {
            Optional cityHelp = cityRepository.findById(Integer.parseInt(id));
            City city = (City) cityHelp.get();
            return city;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find city with id = " + id + ".");
        }
    }

    public City getByName(String name) throws ServiceException {
        try {
            for (City city : cityRepository.findAll()) {
                if (city.getName().equals(name))
                    return city;
            }
            // In case it did not find a city with given name
            throw new Exception();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find city with name = " + name + ".");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            cityRepository.deleteAll();
            return "All cities deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete all cities");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            cityRepository.deleteById(Integer.parseInt(id));
            return "City with id = " + id + " deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete city with id = " + id + ".");
        }
    }

    public String postNewCity(City city) throws ServiceException {
        try {
            cityRepository.save(city);
            return "City with name = " + city.getName() + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot create city with name = " + city.getName() + ".");
        }
    }

    public String putChangeCity(City cityFromRequest) throws ServiceException {
        try {
            Optional cityHelp = cityRepository.findById(cityFromRequest.getId());
            City city = (City) cityHelp.get();
            city.setName(cityFromRequest.getName());
            cityRepository.save(city);
            return "City with id = " + city.getId() + " saved successfully as " + city.getName();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update city with id = " + cityFromRequest.getId() + ".");
        }
    }
}