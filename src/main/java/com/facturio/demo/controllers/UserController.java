package com.facturio.demo.controllers;


import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.exceptions.UserNotFoundException;
import com.facturio.demo.services.UserManagerResponseEntity;
import com.facturio.demo.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usermanager/v1")
public class UserController {
    @Autowired
    private UserServiceInterface service;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody UserDtoRequest user) {
        return UserManagerResponseEntity.OKResponse(201, this.service.register(user));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return UserManagerResponseEntity.OKResponse(200, this.service.getAll());
    }

    @GetMapping("/user/searchByname/{name}")

    public ResponseEntity<?> searchByName(@PathVariable(name = "name") String pattern) {
        return UserManagerResponseEntity.OKResponse(200, this.service.findUserByNameStartsWith(pattern));
    }
    @PostMapping("/login")

    public ResponseEntity<?> login (@RequestBody UserDtoRequest user){
        try {
            return UserManagerResponseEntity.OKResponse(200, this.service.login(user));
        } catch (UserNotFoundException e) {
            return UserManagerResponseEntity.errorResponse(400, e.getMessage());
        }
    }


}
