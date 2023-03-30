package com.facturio.demo.controllers;

import com.facturio.demo.services.UserManagerResponseEntity;
import com.facturio.demo.services.UserServiceInterface;
import com.facturio.demo.tools.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(Constante.BASE_URL + "/admin")
public class AdminController {
    @Autowired
    private UserServiceInterface service;
    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return UserManagerResponseEntity.OKResponse(200, this.service.getAll());
    }

    @GetMapping("/users/searchByname/{name}")
    public ResponseEntity<?> searchByName(@PathVariable(name = "name") String pattern) {
        return UserManagerResponseEntity.OKResponse(200, this.service.findUserByNameStartsWith(pattern));
    }

}
