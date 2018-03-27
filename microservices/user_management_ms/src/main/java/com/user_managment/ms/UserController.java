package com.user_managment.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") String id) {
        Optional user = userRepository.findById(Integer.parseInt(id));
        User u = (User) user.get();
        return u;
    }

    @ResponseBody
    @RequestMapping(value="/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        User u = userRepository.save(user);
        return u;
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String id) {
        userRepository.deleteById(Integer.parseInt(id));
        String s = "User deleted";
        return s;
    }
}
