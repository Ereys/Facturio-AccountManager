package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.exceptions.UserNotFoundException;

import java.util.List;

public interface UserServiceInterface {

    public AppUser register(UserDtoRequest newUser);

    public AppUser login(UserDtoRequest userDtoRequest) throws UserNotFoundException;

    public void setUserRole(Long id, Role status);

    public List<AppUser> getAll();

    public List<AppUser> findUserByNameStartsWith(String pattern);


    List<AppUser> findUserByNameContaining(String pattern);
    AppUser updateUser(Long userId, UserDtoRequest userDto) throws UserNotFoundException;
}
