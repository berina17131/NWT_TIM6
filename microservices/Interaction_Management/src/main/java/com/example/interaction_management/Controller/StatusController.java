package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Status;
import com.example.interaction_management.Repository.UserRepository;
import com.example.interaction_management.Security.TokenAuthenticationService;
import com.example.interaction_management.Service.StatusService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "*")
public class StatusController {

    private StatusService statusService;
    private UserRepository userRepository;

    public StatusController(StatusService statusService, UserRepository userRepository) {
        this.statusService = statusService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(statusService.getAll());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(statusService.getById(id));
    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(statusService.deleteAll());
    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(statusService.deleteById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity postByStatus(@RequestBody Status status) throws ServiceException {
        String usernameFromRequest = userRepository.findById(status.getUser().getId()).get().getUsername();
        String usernameFromToken = TokenAuthenticationService.getTokenUsername();
        if (!usernameFromRequest.equals(usernameFromToken) && !TokenAuthenticationService.isAdmin())
            throw new ServiceException("Not allowed to do changes");
        else return ResponseEntity.ok(statusService.createStatus(status));
    }

    @PutMapping
    public ResponseEntity putById(@RequestBody Status status) throws ServiceException {
        String usernameFromRequest = userRepository.findById(status.getUser().getId()).get().getUsername();
        String usernameFromToken = TokenAuthenticationService.getTokenUsername();
        if (!usernameFromRequest.equals(usernameFromToken) && !TokenAuthenticationService.isAdmin())
            throw new ServiceException("Not allowed to do changes");
        else return ResponseEntity.ok(statusService.putStatus(status));
    }
}
