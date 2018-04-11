package com.example.interaction_management.Service;

import com.example.interaction_management.Model.Event;
import com.example.interaction_management.Model.User;
import com.example.interaction_management.Repository.EventRepository;
import com.example.interaction_management.Repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() throws ServiceException {
        try {
            return userRepository.findAll();
        }catch (Exception e) {
            throw new ServiceException("Cannot fetch all users.");
        }
    }

    public User getById(String id) throws ServiceException {
        try {
            Optional userHelp = userRepository.findById(Integer.parseInt(id));
            User user = (User) userHelp.get();

            return user;
        }catch (Exception e) {
            throw new ServiceException("Cannot find user with id={" + id + "}");
        }
    }

    public User getByUsername(String username) throws ServiceException {
        try {
            for (User user : userRepository.findAll()) {
                if (user.getUsername().equals(username))
                    return user;
            }
            throw new ServiceException("Cannot find user with username={" + username+ "}");
        }catch (Exception e) {
            throw new ServiceException("Cannot find user with username={" + username + "}");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            userRepository.deleteAll();
            return "All users deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannon delete all users");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            userRepository.deleteById(Integer.parseInt(id));
            return "user with id=" + id + " deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannot delete user with id={" + id + "}");
        }
    }

 /*   public String postByUsername(String username) throws ServiceException {
        try {
            User user;
            user = new User(username);
            userRepository.save(user);

            return "user with title " + username + " saved successfully";
        }catch (Exception e) {
            throw new ServiceException("Cannot save user with title={" + username + "}");
        }
    }

    public String putById(String id, String newUsername) throws ServiceException {
        try {
            Optional userHelp = userRepository.findById(Integer.parseInt(id));
            User user = (User) userHelp.get();
            String oldUsername = user.getUsername();
            user.setUsername(newUsername);
            userRepository.save(user);

            return "User with old title " + oldUsername + " saved successfully as " + newUsername;
        }catch (Exception e) {
            throw new ServiceException("Cannot change user.");
        }
    }

    public String putByUsername(String oldUsername, String newUsername) throws ServiceException {
        try {
            User user = null;
            for (User userHelp : userRepository.findAll()) {
                if (userHelp.getUsername().equals(oldUsername))
                    user = userHelp;
            }
            user.setUsername(newUsername);
            userRepository.save(user);

            return "User with old username " + oldUsername + " saved successfully as " + newUsername;
        }catch (Exception e) {
            throw new ServiceException("Cannot change user.");
        }
    }*/
 public String createUser(int id, String username) throws ServiceException {
     try {
         User u;
         u = new User(id, username);
         System.out.println("HEHEHEHHEHEEH");
         System.out.println(u);
         userRepository.saveUser(id, username);

         return "User with name = " + u.getUsername() + " saved successfully";
     }
     catch (Exception e) {
         throw new ServiceException("Cannot create user with name = " + username + ".");
     }
 }

    public String putUser(int id, User userFromRequest) throws ServiceException {
        try {
            Optional userHelp = userRepository.findById(id);
            User user = (User) userHelp.get();
            user.setUsername(userFromRequest.getUsername());
            userRepository.changeUser(id, user.getUsername());

            return "User with id = " + id + " saved successfully as " + user.getUsername();
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update user with id = " + userFromRequest.getId() + ".");
        }
    }
}
