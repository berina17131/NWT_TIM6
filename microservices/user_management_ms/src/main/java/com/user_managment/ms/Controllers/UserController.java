package com.user_managment.ms.Controllers;

import com.user_managment.ms.Models.User;
import com.user_managment.ms.Services.UserServiceForCRUD;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private UserServiceForCRUD userServiceForCRUD;

    public UserController(UserServiceForCRUD userServiceForCRUD) {
        this.userServiceForCRUD = userServiceForCRUD;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity all() throws ServiceException {
        return ResponseEntity.ok(userServiceForCRUD.getAllUsers());
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity getUser(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(userServiceForCRUD.getUser(id));
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceForCRUD.createUser(user));
    }


    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userServiceForCRUD.deleteUser(id));
    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteAllUsers() {
        return ResponseEntity.ok(userServiceForCRUD.deleteAllUsers());
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity putChangeUser(@RequestBody User user) throws ServiceException {
        return ResponseEntity.ok(userServiceForCRUD.putChangeUser(user));
    }
}
