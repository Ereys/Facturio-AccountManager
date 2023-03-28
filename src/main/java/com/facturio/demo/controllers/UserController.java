package com.facturio.demo.controllers;


import com.facturio.demo.entities.User;
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

    @PostMapping("/user")
    public ResponseEntity <?> create(@RequestBody User user){
        return UserManagerResponseEntity.OKResponse(200, this.service.register(user));
    }

    @GetMapping("/user/searchByname/{name}")

    public ResponseEntity<?> searchByName(@PathVariable(name = "name") String pattern){
        return UserManagerResponseEntity.OKResponse(200, this.service.findUserByNameStartsWith(pattern));

    }


}
