package com.example.place_management.Controller;

import com.example.place_management.Model.Address;
import com.example.place_management.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Address getById(@PathVariable("id") String id) {
        Optional addressHelp = addressRepository.findById(Integer.parseInt(id));
        Address address = (Address) addressHelp.get();

        return address;
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public Address getByName(@PathVariable("name") String name) {
        for (Address address : addressRepository.findAll()) {
            if(address.getName().equals(name))
                return address;
        }

        return null;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        addressRepository.deleteById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postById(Address address) {
        addressRepository.save(address);

        return "OK";
    }
}