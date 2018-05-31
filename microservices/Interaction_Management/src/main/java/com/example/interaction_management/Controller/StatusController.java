package com.example.interaction_management.Controller;

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

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
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
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(statusService.deleteById(id));
    }

    @PostMapping(value = "/create/{status}")
    public ResponseEntity postByStatus(@PathVariable("status") String st) throws ServiceException {
        return ResponseEntity.ok(statusService.postByStatus(st));
    }

    @PutMapping(value = "/id/{id}/newStatus/{newStatus}")
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newStatus") String newStatus) throws ServiceException {
        return ResponseEntity.ok(statusService.putById(id, newStatus));
    }
}
