package com.example.interaction_management.Controller;

import com.example.interaction_management.Service.StatusService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(statusService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(statusService.getById(id));
    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(statusService.deleteAll());
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(statusService.deleteById(id));
    }

    @RequestMapping(value={"/create/{status}"}, method = RequestMethod.POST)
    public ResponseEntity postByStatus(@PathVariable("status") String st) throws ServiceException {
        return ResponseEntity.ok(statusService.postByStatus(st));
    }

    @RequestMapping(value={"/id/{id}/newStatus/{newStatus}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newStatus") String newStatus) throws ServiceException {
        return ResponseEntity.ok(statusService.putById(id, newStatus));
    }
}
