package com.user_managment.ms.Services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.user_managment.ms.Models.User;
import com.user_managment.ms.Repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private EurekaClient discoveryClient;

    public User createUser(User user) throws ServiceException {
        try {
            User u = userRepository.save(user);
            System.out.println(u);
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("INTERACTION_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForEntity("http://localhost:" + Integer.toString(instance.getPort()) + "/user/create/" + u.getId() + "/" + user.getUsername(), null, null);
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

    public String putChangeUser(User u) throws ServiceException {
        try {
            Optional userHelp = userRepository.findById(u.getId());
            User user = (User) userHelp.get();
            user.setUsername(u.getUsername());
            userRepository.save(user);

            InstanceInfo instance = discoveryClient.getNextServerFromEureka("INTERACTION_MANAGEMENT", false);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put("http://localhost:" + Integer.toString(instance.getPort()) + "/user", user, User.class);
            return "User with id = " + u.getId() + " saved successfully";
        }
        catch (Exception e) {
            throw new ServiceException("Cannot update place with id = " + u.getId() + ".");
        }
    }
}