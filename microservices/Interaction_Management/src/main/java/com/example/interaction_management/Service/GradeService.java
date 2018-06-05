package com.example.interaction_management.Service;

import com.example.interaction_management.Model.Grade;
import com.example.interaction_management.Repository.GradeRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAll() throws ServiceException {
        try {
            return gradeRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Cannot fetch all grades.");
        }
    }

    public float getAverageGradeForEvent(String id) throws ServiceException {
        try {
            List<Grade> grades = gradeRepository.findAll();
            float averageGrade = 0;
            int count = 0;

            for (Grade e : grades) {
                if (e.getEvent().getId() == Integer.parseInt(id)) {
                    count++;
                    averageGrade += e.getGrade();

                }
            }

            return averageGrade / count;
            /*Optional gradeHelp = gradeRepository.findById(Integer.parseInt(id));
            Grade grade = (Grade) gradeHelp.get();

            return grade;*/
        } catch (Exception e) {
            throw new ServiceException("Cannot find grade with id={" + id + "}");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            gradeRepository.deleteAll();
            return "All grades deleted";

        } catch (Exception e) {
            throw new ServiceException("Cannon delete all grades");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            gradeRepository.deleteById(Integer.parseInt(id));
            return "Grade with id=" + id + " deleted";

        } catch (Exception e) {
            throw new ServiceException("Cannot delete grade with id={" + id + "}");
        }
    }

    public String createGrade(Grade grade) throws ServiceException {
        try {
            gradeRepository.save(grade);

            return "Grade = " + grade.getGrade() + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot create grade = " + grade.getGrade() + ".");
        }
    }

    public String putGrade(Grade gradeFromRequest) throws ServiceException {
        try {
            Optional gradeHelp = gradeRepository.findById(gradeFromRequest.getId());
            Grade grade = (Grade) gradeHelp.get();
            grade.setGrade(gradeFromRequest.getGrade());
            gradeRepository.save(grade);

            return JSONParser.quote("Grade with id= " + grade.getId() + " saved successfully as " + grade.getGrade());
        } catch (Exception e) {
            throw new ServiceException(JSONParser.quote("Cannot update grade with id = " + gradeFromRequest.getId() + "."));
        }
    }
}
