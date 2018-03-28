package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.Comment;
import com.example.interaction_management.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentRepository commentRepository;

    @Autowired
    CommentController(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Comment getById (@RequestParam(value = "id") String id)
    {
        Optional comment1 = commentRepository.findById(Integer.parseInt(id));
        Comment comment = (Comment) comment1.get();

        return comment;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById (@RequestParam(value = "id") String id)
    {
        try{
            commentRepository.deleteById(Integer.parseInt(id));
            return "Comment with id=" + id + " deleted.";
        }
        catch(Exception name) {
            return "Couldn't find event with id=" + id + ".";
        }
    }

    @RequestMapping(value="/text/{text}", method = RequestMethod.POST)
    public String postByText (@PathVariable("text") String text)
    {
        try {
            Comment comment = new Comment(text);
            commentRepository.save(comment);

            return "Comment created successfully.";
        } catch(Exception ex) {
            return "Error, operation could not be completed.";
        }
    }
}
