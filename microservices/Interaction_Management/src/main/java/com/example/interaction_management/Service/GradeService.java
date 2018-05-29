package com.example.interaction_management.Service;

import com.example.interaction_management.Model.Grade;
import com.example.interaction_management.Repository.GradeRepository;
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

    public Grade getById(String id) throws ServiceException {
        try {
            Optional gradeHelp = gradeRepository.findById(Integer.parseInt(id));
            Grade grade = (Grade) gradeHelp.get();

            return grade;
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

    public String postByGrade(int gr) throws ServiceException {
        try {
            Grade grade;
            grade = new Grade(gr);
            gradeRepository.save(grade);

            return "Grade=" + gr + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot save grade={" + gr + "}");
        }
    }

    public String putById(String id, int newGrade) throws ServiceException {
        try {
            Optional gradeHelp = gradeRepository.findById(Integer.parseInt(id));
            Grade grade = (Grade) gradeHelp.get();
            grade.setGr(newGrade);
            gradeRepository.save(grade);
            return "Grade with id=" + id + " changed to " + newGrade;
        } catch (Exception e) {
            throw new ServiceException("Cannot change grade.");
        }
    }

    public String createGrade(Grade grade) throws ServiceException {
        try {
            gradeRepository.save(grade);

            return "Grade = " + grade.getGr() + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot create grade = " + grade.getGr() + ".");
        }
    }

    public String putGrade(Grade gradeFromRequest) throws ServiceException {
        try {
            Optional gradeHelp = gradeRepository.findById(gradeFromRequest.getId());
            Grade grade = (Grade) gradeHelp.get();
            grade.setGr(gradeFromRequest.getGr());
            gradeRepository.save(grade);

            return "Grade with id= " + grade.getId() + " saved successfully as " + grade.getGr();
        } catch (Exception e) {
            throw new ServiceException("Cannot update grade with id = " + gradeFromRequest.getId() + ".");
        }
    }
}
