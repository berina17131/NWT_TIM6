package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.User;
import com.example.interaction_management.Service.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/id/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping(value = "/username/{username}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity getByUsername(@PathVariable("username") String username) throws ServiceException {
        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(userService.deleteAll());
    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PostMapping(value = "/create/{id}/{username}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity createUser(@PathVariable("id") int id, @PathVariable("username") String username) throws ServiceException {
        return ResponseEntity.ok(userService.createUser(id, username));
    }

    @PutMapping(value = "/update/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity putUser(@PathVariable("id") int id, @RequestBody User user) throws ServiceException {
        return ResponseEntity.ok(userService.putUser(id, user));
    }
}
