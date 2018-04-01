package com.user_managment.ms.Services;

import com.user_managment.ms.Models.User;
import com.user_managment.ms.Repository.UserRepository;
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

    public List<User> getAllUsers() throws ServiceException {
        try {
            List<User> users = userRepository.findAll();
            return users;
        } catch (Exception e) {
            throw new ServiceException("Cannot fetch all users.");
        }
    }

    public User getUser(String id) throws ServiceException {
        try {
            Optional user = userRepository.findById(Integer.parseInt(id));
            User u = (User) user.get();
            return u;
        } catch (Exception e) {
            throw new ServiceException("Cannot find user with id={" + id + "}");
        }
    }

    public User createUser(User user) throws ServiceException {
        try {
            User u = userRepository.save(user);
            return u;
        } catch (Exception e) {
            throw new ServiceException("Cannot create user");
        }
    }

    public String deleteUser(String id) throws ServiceException {
        try {
            userRepository.deleteById(Integer.parseInt(id));
            return "User deleted";
        } catch (Exception e) {
            throw new ServiceException("Cannot delete user with id={" + id + "}");
        }
    }

    public String deleteAllUsers() throws ServiceException {
        try {
            userRepository.deleteAll();
            String s = "Users deleted";
            return s;
        }
        catch(Exception e) {
            throw new ServiceException("Cannon delete all users");
        }
    }
}