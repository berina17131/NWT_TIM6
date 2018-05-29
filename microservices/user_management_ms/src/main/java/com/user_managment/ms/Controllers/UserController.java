package com.user_managment.ms.Controllers;

import com.user_managment.ms.Models.User;
import com.user_managment.ms.Services.UserServiceForCRUD;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private UserServiceForCRUD userServiceForCRUD;

    public UserController(UserServiceForCRUD userServiceForCRUD) {
        this.userServiceForCRUD = userServiceForCRUD;
    }

    @RequestMapping("/all")
    public ResponseEntity all() throws ServiceException {
        return ResponseEntity.ok(userServiceForCRUD.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(userServiceForCRUD.getUser(id));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceForCRUD.createUser(user));
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userServiceForCRUD.deleteUser(id));
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllUsers() {
        return ResponseEntity.ok(userServiceForCRUD.deleteAllUsers());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangeUser(@RequestBody User user) throws ServiceException {
        return ResponseEntity.ok(userServiceForCRUD.putChangeUser(user));
    }
}
