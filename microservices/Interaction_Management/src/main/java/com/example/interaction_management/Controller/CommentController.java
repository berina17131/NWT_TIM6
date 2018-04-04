package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Comment;
import com.example.interaction_management.Repository.CommentRepository;
import com.example.interaction_management.Service.CommentService;
import com.example.interaction_management.Service.GradeService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(commentService.getAll());
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(commentService.getById(id));
    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(commentService.deleteAll());
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(commentService.deleteById(id));
    }

    @RequestMapping(value={"/create/{comment}"}, method = RequestMethod.POST)
    public ResponseEntity postByComment(@PathVariable("comment") String co) throws ServiceException {
        return ResponseEntity.ok(commentService.postByComment(co));
    }

    @RequestMapping(value={"/id/{id}/newComment/{newComment}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newComment") String newComment) throws ServiceException {
        return ResponseEntity.ok(commentService.putById(id, newComment));
    }
}
