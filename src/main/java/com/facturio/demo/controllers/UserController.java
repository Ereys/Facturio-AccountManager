package com.facturio.demo.controllers;


import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.exceptions.UserNotFoundException;
import com.facturio.demo.services.AuthenticateService;
import com.facturio.demo.services.UserManagerResponseEntity;
import com.facturio.demo.services.UserServiceInterface;
import com.facturio.demo.tools.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constante.BASE_URL + "/user")
public class UserController {
    @Autowired
    private UserServiceInterface service;

    @Autowired
    private AuthenticateService authService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody UserDtoRequest user) {
        try {
            return this.authService.register(user);
        }catch(Exception e){
            System.out.println(e);
            return UserManagerResponseEntity.errorResponse(400, "Register error");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody UserDtoRequest user){
        try {
            return this.authService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            return UserManagerResponseEntity.errorResponse(400, "Login error");
        }
    }
}
