package com.example.interaction_management.Service;

import com.example.interaction_management.Model.Comment;
import com.example.interaction_management.Repository.CommentRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll() throws ServiceException {
        try {
            return commentRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Cannot fetch all comments.");
        }
    }

   /* public Comment getById(String id) throws ServiceException {
        try {
            Optional commentHelp = commentRepository.findById(Integer.parseInt(id));
            Comment comment = (Comment) commentHelp.get();

            return comment;
        }catch (Exception e) {
            throw new ServiceException("Cannot find comment with id={" + id + "}");
        }
    }*/

    public List<Comment> getByEventId(String id) throws ServiceException {
        try {
            List<Comment> comments = commentRepository.findAll();
            Set<Comment> commentsSet = new HashSet<>();

            for (Comment e : comments) {
                if (e.getEvent().getId() == Integer.parseInt(id)) {
                    commentsSet.add(e);
                }
            }

            return new ArrayList<>(commentsSet);
        } catch (Exception e) {
            throw new ServiceException("Cannot fetch all events.");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            commentRepository.deleteAll();
            return "All comments deleted";

        } catch (Exception e) {
            throw new ServiceException("Cannon delete all comments");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            commentRepository.deleteById(Integer.parseInt(id));
            return "Comment with id=" + id + " deleted";

        } catch (Exception e) {
            throw new ServiceException("Cannot delete comment with id={" + id + "}");
        }
    }

    public String postByComment(String co) throws ServiceException {
        try {
            Comment comment;
            comment = new Comment(co);
            commentRepository.save(comment);

            return "Comment=" + co + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot save comment={" + co + "}");
        }
    }

    public String putById(String id, String newComment) throws ServiceException {
        try {
            Optional commentHelp = commentRepository.findById(Integer.parseInt(id));
            Comment comment = (Comment) commentHelp.get();
            comment.setComment(newComment);
            commentRepository.save(comment);
            return "Comment with id=" + id + " changed to " + newComment;
        } catch (Exception e) {
            throw new ServiceException("Cannot change comment.");
        }
    }

    public String createComment(Comment comment) throws ServiceException {
        try {
            commentRepository.save(comment);

            return "Comment = " + comment.getComment() + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot create comment = " + comment.getComment() + ".");
        }
    }

    public String putComment(Comment commentFromRequest) throws ServiceException {
        try {
            Optional commentHelp = commentRepository.findById(commentFromRequest.getId());
            Comment comment = (Comment) commentHelp.get();
            comment.setComment(commentFromRequest.getComment());
            commentRepository.save(comment);

            return "Comment with id= " + comment.getId() + " saved successfully as " + comment.getComment();
        } catch (Exception e) {
            throw new ServiceException("Cannot update comment with id = " + commentFromRequest.getId() + ".");
        }
    }
}
