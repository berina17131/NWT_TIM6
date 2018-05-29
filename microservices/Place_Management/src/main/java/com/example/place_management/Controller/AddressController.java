package com.example.place_management.Controller;

import com.example.place_management.Model.Address;
import com.example.place_management.Service.AddressService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(addressService.getAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(addressService.getByName(name));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(addressService.deleteAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(addressService.deleteById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postNewAddress(@RequestBody Address address) throws ServiceException {
        return ResponseEntity.ok(addressService.postNewAddress(address));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangeAddress(@RequestBody Address address) throws ServiceException {
        return ResponseEntity.ok(addressService.putChangeAddress(address));
    }
}