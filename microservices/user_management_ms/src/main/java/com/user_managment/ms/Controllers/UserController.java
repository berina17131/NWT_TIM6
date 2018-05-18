package com.user_managment.ms.Controllers;

import com.user_managment.ms.Models.User;
import com.user_managment.ms.Services.UserService;
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

    @RequestMapping("/all")
    public ResponseEntity all() throws ServiceException {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllUsers() {
        return ResponseEntity.ok(userService.deleteAllUsers());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangeUser(@RequestBody User user) throws ServiceException {
        return ResponseEntity.ok(userService.putChangeUser(user));
    }
}
