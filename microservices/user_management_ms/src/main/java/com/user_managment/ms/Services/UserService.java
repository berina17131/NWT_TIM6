package com.user_managment.ms.Services;

import com.user_managment.ms.Models.User;
import com.user_managment.ms.Models.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);

    List<User> findAll();

    User getByUserName(String userName);
}
