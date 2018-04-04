package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.User;
import com.example.interaction_management.Repository.UserRepository;
import com.example.interaction_management.Service.EventService;
import com.example.interaction_management.Service.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(userService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(userService.getById(id));
    }

    @RequestMapping(value="/username/{username}", method = RequestMethod.GET)
    public ResponseEntity getByUsername(@PathVariable("username") String username) throws ServiceException {
        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(userService.deleteAll());
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @RequestMapping(value={"/create/{username}"}, method = RequestMethod.POST)
    public ResponseEntity postByUsenname(@PathVariable("username") String username) throws ServiceException {
        return ResponseEntity.ok(userService.postByUsername(username));
    }

    @RequestMapping(value={"/id/{id}/newUsername/{newUsername}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newUsername") String newUsername) throws ServiceException {
        return ResponseEntity.ok(userService.putById(id, newUsername));
    }

    @RequestMapping(value={"/oldUsername/{oldUsername}/newUsername/{newUsername}"}, method = RequestMethod.PUT)
    public ResponseEntity putByUsername(@PathVariable("oldUsername") String oldUsername, @PathVariable("newUsername") String newUsername) throws ServiceException {
        return ResponseEntity.ok(userService.putByUsername(oldUsername, newUsername));
    }
}
