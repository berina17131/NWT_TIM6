package com.example.place_management.Controller;

import com.example.place_management.Model.Address;
import com.example.place_management.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Address> getAll() {
        return addressRepository.findAll();
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

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteAll() {
        addressRepository.deleteAll();

        return "All addresses deleted";
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        addressRepository.deleteById(Integer.parseInt(id));

        return "Address with id=" + id + " deleted";
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.POST)
    public String postByName(@PathVariable("name") String name) {
        Address address = new Address(name);
        addressRepository.save(address);

        return "Address with name " + name + " saved successfully";
    }

    @RequestMapping(value="/id/{id}/newName/{newName}", method = RequestMethod.PUT)
    public String putById(@PathVariable("id") String id, @PathVariable("newName") String newName) {
        Optional addressHelp = addressRepository.findById(Integer.parseInt(id));
        Address address = (Address) addressHelp.get();
        String oldName = address.getName();
        address.setName(newName);
        addressRepository.save(address);

        return "Address with old name " + oldName  + " saved successfully as " + newName;
    }

    @RequestMapping(value="/oldName/{oldName}/newName/{newName}", method = RequestMethod.PUT)
    public String putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {
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