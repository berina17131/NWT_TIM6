package com.example.place_management.Service;

import com.example.place_management.Model.Address;
import com.example.place_management.Repository.AddressRepository;
import org.hibernate.service.spi.ServiceException;
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

    public List<Address> getAll() throws ServiceException {
        try {
            return addressRepository.findAll();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot fetch all addresses.");
        }
    }

    public Address getById(String id) throws ServiceException {
        try {
            Optional addressHelp = addressRepository.findById(Integer.parseInt(id));
            Address address = (Address) addressHelp.get();
            return address;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find address with id = " + id + ".");
        }
    }

    public Address getByName(String name) throws ServiceException {
        try {
            for (Address address : addressRepository.findAll()) {
                if (address.getName().equals(name))
                    return address;
            }
            // In case it did not find an address with given name
            throw new Exception();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot find address with name = " + name + ".");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            addressRepository.deleteAll();
            return "All addresses deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete all addresses");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            addressRepository.deleteById(Integer.parseInt(id));
            return "Address with id = " + id + " deleted";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot delete address with id = " + id + ".");
        }
    }

    public String postByName(Address address) throws ServiceException {
        try {
            addressRepository.save(address);
            return "Address with name = " + address.getName() + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot create address with name = " + address.getName() + ".");
        }
    }

    public String putById(String id, String newName) throws ServiceException {
        try {
            Optional addressHelp = addressRepository.findById(Integer.parseInt(id));
            Address address = (Address) addressHelp.get();
            address.setName(newName);
            addressRepository.save(address);
            return "Address with id = " + id + " saved successfully as " + newName;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update address with id = " + id + ".");
        }
    }

    public String putByName(String oldName, String newName) throws ServiceException {
        try {
            Address address = null;
            for (Address addressHelp : addressRepository.findAll()) {
                if (addressHelp.getName().equals(oldName))
                    address = addressHelp;
            }
            address.setName(newName);
            addressRepository.save(address);
            return "Address with old name = " + oldName + " saved successfully as " + newName;
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update address with name = " + oldName + ".");
        }
    }
}