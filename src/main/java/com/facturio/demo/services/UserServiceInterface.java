package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.exceptions.AccountAlreadyExistException;
import com.facturio.demo.exceptions.UserNotFoundException;

import java.util.List;

public interface UserServiceInterface {
    public AppUser AddUser(AppUser newUser);

    public void setUserRole(AppUser user, Role status);

    public List<AppUser> getAll();

    public List<AppUser> findUserByNameStartsWith(String pattern);


    List<AppUser> findUserByNameContaining(String pattern);
}
