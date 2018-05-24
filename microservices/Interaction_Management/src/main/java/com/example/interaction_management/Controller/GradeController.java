package com.example.interaction_management.Controller;

import com.example.interaction_management.Service.GradeService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "*")
public class GradeController {

    private GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(gradeService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(gradeService.getById(id));
    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(gradeService.deleteAll());
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(gradeService.deleteById(id));
    }

    @RequestMapping(value={"/create/{grade}"}, method = RequestMethod.POST)
    public ResponseEntity postByGrade(@PathVariable("grade") int gr) throws ServiceException {
        return ResponseEntity.ok(gradeService.postByGrade(gr));
    }

    @RequestMapping(value={"/id/{id}/newGrade/{newGrade}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newGrade") int newGrade) throws ServiceException {
        return ResponseEntity.ok(gradeService.putById(id, newGrade));
    }
}
