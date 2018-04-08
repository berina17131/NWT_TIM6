package com.example.place_management.Controller;

import com.example.place_management.Service.AddressService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(addressService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(addressService.getByName(name));
    }

    @RequestMapping(value="/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(addressService.deleteAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(addressService.deleteById(id));
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.POST)
    public ResponseEntity postByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(addressService.postByName(name));
    }

    @RequestMapping(value="/id/{id}/newName/{newName}", method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newName") String newName) throws ServiceException {
        return ResponseEntity.ok(addressService.putById(id, newName));
    }

    @RequestMapping(value="/oldName/{oldName}/newName/{newName}", method = RequestMethod.PUT)
    public ResponseEntity putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) throws ServiceException {
        return ResponseEntity.ok(addressService.putByName(oldName, newName));
    }
}