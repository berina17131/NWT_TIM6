package com.example.interaction_management.Controller;

import com.example.interaction_management.Model.User;
import com.example.interaction_management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public User getById (@RequestParam(value = "id") String id)
    {
        Optional user1 = userRepository.findById(Integer.parseInt(id));
        User user = (User) user1.get();

        return user;
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById (@RequestParam(value = "id") String id)
    {
        try{
            userRepository.deleteById(Integer.parseInt(id));
            return "User with id=" + id + " deleted.";
        }
        catch(Exception name) {
            return "Couldn't find event with id=" + id + ".";
        }
    }

    @RequestMapping(value="/username/{username}", method = RequestMethod.POST)
    public String postByUsername (@PathVariable("username") String username) {
        try {
            User user = new User(username);
            userRepository.save(user);

            return "User created successfully.";
        } catch (Exception ex) {
            return "Error, operation could not be completed.";
        }
    }
}
