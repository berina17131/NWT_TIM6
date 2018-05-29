package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.User;
import com.example.interaction_management.Service.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(userService.getAll());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(userService.getById(id));
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public ResponseEntity getByUsername(@PathVariable("username") String username) throws ServiceException {
        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(userService.deleteAll());
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @RequestMapping(value = "/create/{id}/{username}", method = RequestMethod.POST)
    public ResponseEntity createUser(@PathVariable("id") int id, @PathVariable("username") String username) throws ServiceException {
        System.out.println(id);
        System.out.println(username);
        return ResponseEntity.ok(userService.createUser(id, username));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity putUser(@PathVariable("id") int id, @RequestBody User user) throws ServiceException {
        System.out.println(user);
        return ResponseEntity.ok(userService.putUser(id, user));
    }
}
