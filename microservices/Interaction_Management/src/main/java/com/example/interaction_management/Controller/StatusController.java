package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Status;
import com.example.interaction_management.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusRepository statusRepository;

    @Autowired
    StatusController(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Status getById (@RequestParam(value = "id") String id)
    {
        Optional status1 = statusRepository.findById(Integer.parseInt(id));
        Status status = (Status) status1.get();

        return status;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById (@RequestParam(value = "id") String id)
    {
        try{
            statusRepository.deleteById(Integer.parseInt(id));
            return "Status with id=" + id + " deleted.";
        }
        catch(Exception name) {
            return "Couldn't find event with id=" + id + ".";
        }
    }

    @RequestMapping(value="/status/{status}", method = RequestMethod.POST)
    public String postByStatus (@PathVariable("status") String stat) {
        try {
            Status status = new Status(stat);
            statusRepository.save(status);

            return "Status created successfully.";
        } catch (Exception ex) {
            return "Error, operation could not be completed.";
        }
    }
}
