package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.User;
import com.facturio.demo.entities.enums.Role;

import java.util.List;

public interface UserServiceInterface {
    public User register (User newUser);
    public User login (UserDtoRequest userDtoRequest);
    public void setUserRole (Long id, Role status);
    public List<User> getAll();
    public List<User> findUserByNameStartsWith(String pattern);


    List<User> findUserByNameContaining(String pattern);
}
