package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Grade;
import com.example.interaction_management.Repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeRepository gradeRepository;

    @Autowired
    GradeController(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Grade getById (@RequestParam(value = "id") String id)
    {
        Optional grade1 = gradeRepository.findById(Integer.parseInt(id));
        Grade grade = (Grade) grade1.get();

        return grade;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById (@RequestParam(value = "id") String id)
    {
        try{
            gradeRepository.deleteById(Integer.parseInt(id));
            return "Grade with id=" + id + " deleted.";
        }
        catch(Exception name) {
            return "Couldn't find event with id=" + id + ".";
        }
    }


    @RequestMapping(value="/grade/{grade}", method = RequestMethod.POST)
    public String postByGrade (@PathVariable("grade") String gra)
    {
        try {
            Grade grade = new Grade(Integer.parseInt(gra));
            gradeRepository.save(grade);

            return "Grade created successfully.";
        }
        catch (Exception ex) {
            return "Error, operation could not be completed.";
        }
    }
}
