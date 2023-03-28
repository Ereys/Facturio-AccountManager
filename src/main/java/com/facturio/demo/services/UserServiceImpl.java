package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.User;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface  {


    @Autowired
    private UserRepository register;


    @Override
    public User register (User newUser) {
        return this.register.save(newUser);

    }

    @Override
    public User login(UserDtoRequest userDtoRequest) {
        return null;
    }


    @Override
    public void setUserRole(Long id, Role role) {
        User target = this.register.findById(id).orElseThrow();
        target.setRole(role);

    }

    @Override
    public List<User> getAll() {

        return this.register.findAll();
    }

    @Override
    public List<User> findUserByNameStartsWith(String pattern) {
        return null;
    }

    @Override
    public List<User> findUserByNameContaining(String pattern) {

        return this.register.findUserByNameStartsWith(pattern);
    }
}
