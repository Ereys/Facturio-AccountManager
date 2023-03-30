package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.exceptions.AccountAlreadyExistException;
import org.springframework.http.ResponseEntity;

public interface AuthenticateServiceInterface {
    public ResponseEntity<String> register (UserDtoRequest newUser) throws AccountAlreadyExistException;
    public ResponseEntity<String> login(UserDtoRequest request);


}
