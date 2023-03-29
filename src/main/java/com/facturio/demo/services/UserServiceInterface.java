package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;

import java.util.List;

public interface UserServiceInterface {
    public AppUser register(AppUser newUser);

    public AppUser login(UserDtoRequest userDtoRequest);

    public void setUserRole(Long id, Role status);

    public List<AppUser> getAll();

    public List<AppUser> findUserByNameStartsWith(String pattern);


    List<AppUser> findUserByNameContaining(String pattern);
}
