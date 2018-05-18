package com.example.interaction_management.Controller;

import com.example.interaction_management.Service.CommentService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
