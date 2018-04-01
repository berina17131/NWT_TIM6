package com.example.place_management.Service;

import com.example.place_management.Model.Address;
import com.example.place_management.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(String id) {
        Optional addressHelp = addressRepository.findById(Integer.parseInt(id));
        Address address = (Address) addressHelp.get();

        return address;
    }

    public Address getByName(String name) {
        for (Address address : addressRepository.findAll()) {
            if(address.getName().equals(name))
                return address;
        }

        return null;
    }

    public String deleteAll() {
        addressRepository.deleteAll();

        return "All addresses deleted";
    }

    public String deleteById(String id) {
        addressRepository.deleteById(Integer.parseInt(id));

        return "Address with id=" + id + " deleted";
    }

    public String postByName(String name) {
        Address address = new Address(name);
        addressRepository.save(address);

        return "Address with name " + name + " saved successfully";
    }

    public String putById(String id, String newName) {
        Optional addressHelp = addressRepository.findById(Integer.parseInt(id));
        Address address = (Address) addressHelp.get();
        String oldName = address.getName();
        address.setName(newName);
        addressRepository.save(address);

        return "Address with old name " + oldName  + " saved successfully as " + newName;
    }

    public String putByName(String oldName, String newName) {
        Address address = null;
        for (Address addressHelp : addressRepository.findAll()) {
            if(addressHelp.getName().equals(oldName))
                address = addressHelp;
        }
        address.setName(newName);
        addressRepository.save(address);

        return "Address with old name " + oldName  + " saved successfully as " + newName;
    }
}