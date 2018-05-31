package com.example.interaction_management.Controller;

import com.example.interaction_management.Service.GradeService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "*")
public class GradeController {

    private GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(gradeService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(gradeService.getAverageGradeForEvent(id));
    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(gradeService.deleteAll());
    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(gradeService.deleteById(id));
    }

    @PostMapping(value = "/create/{grade}")
    public ResponseEntity postByGrade(@PathVariable("grade") int gr) throws ServiceException {
        return ResponseEntity.ok(gradeService.postByGrade(gr));
    }

    @PutMapping(value = "/id/{id}/newGrade/{newGrade}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newGrade") int newGrade) throws ServiceException {
        return ResponseEntity.ok(gradeService.putById(id, newGrade));
    }
}
