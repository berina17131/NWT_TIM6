package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Comment;
import com.example.interaction_management.Service.CommentService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(commentService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(commentService.getByEventId(id));
    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(commentService.deleteAll());
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(commentService.deleteById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity postByComment(@RequestBody Comment comment) throws ServiceException {
        return ResponseEntity.ok(commentService.postByComment(comment));
    }

    @PutMapping
    public ResponseEntity putById(@RequestBody Comment comment) throws ServiceException {
        return ResponseEntity.ok(commentService.putComment(comment));
    }
}
