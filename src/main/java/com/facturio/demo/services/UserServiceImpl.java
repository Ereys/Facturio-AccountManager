package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.exceptions.UserNotFoundException;
import com.facturio.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface  {


    @Autowired
    private UserRepository userRepository;


    @Override
    public AppUser register (UserDtoRequest newUser) {
        return this.userRepository.save(AppUser.builder()
                .name(newUser.getName())
                .password(newUser.getPassword())
                .build());

    }

    @Override
    public AppUser login(UserDtoRequest userDtoRequest) throws UserNotFoundException {
        AppUser target = this.userRepository.findUserByName(userDtoRequest.getName());
        if (target == null){
            throw new UserNotFoundException(userDtoRequest.getName() + "User not found");
        }

        if (target.getPassword() != userDtoRequest.getPassword()) {
            throw new UserNotFoundException("User not found");
        }
        return target;
    }


    @Override
    public void setUserRole(Long id, Role role) {
        AppUser target = this.userRepository.findById(id).orElseThrow();
        target.setRole(role);

    }

    @Override
    public List<AppUser> getAll() {

        return this.userRepository.findAll();
    }

    @Override
    public List<AppUser> findUserByNameStartsWith(String pattern) {
         return this.userRepository.findUserByNameStartsWith(pattern);
    }

    @Override
    public List<AppUser> findUserByNameContaining(String pattern) {
        return this.userRepository.findUserByNameStartsWith(pattern);
    }

}
