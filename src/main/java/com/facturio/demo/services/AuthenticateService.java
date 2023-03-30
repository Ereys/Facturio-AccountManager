package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.exceptions.AccountAlreadyExistException;
import com.facturio.demo.repositories.UserRepository;
import com.facturio.demo.securities.JwtAuthentificationFilter;
import com.facturio.demo.tools.Constante;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticateService implements AuthenticateServiceInterface{

    private final UserServiceInterface userService;
    private final JWTService jwt;
    private final AuthenticationManager manager;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> register (UserDtoRequest newUser) throws AccountAlreadyExistException {
        System.out.println(newUser.getEmail());
        if(this.userRepository.findByEmail(newUser.getEmail()).isPresent()) throw new AccountAlreadyExistException("Register error");
        AppUser user = AppUser.builder()
                .name(newUser.getName())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .build();
        this.userService.AddUser(user);
        this.userService.setUserRole(user, Role.WORKER);
        return ResponseEntity.ok()
                .headers(putTokenOnHeaders(user))
                .body(Constante.REGISTER_SUCCES);
    }
    @Override
    public ResponseEntity<String> login(UserDtoRequest request) {
        System.out.println("login : "   + request.toString());
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
                )
        );
        System.out.println(authentication.getName());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(request.getEmail());
        var user = this.userRepository.findByEmail(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Login error"));
        return ResponseEntity.ok().headers(putTokenOnHeaders(user)).body(Constante.LOGIN_SUCCES);
    }
    public HttpHeaders putTokenOnHeaders(AppUser user) {
        var jwtToken = jwt.generateToken(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(Constante.HEADERS_KEY, Constante.HEADERS_PREFIX + jwtToken);
        return responseHeaders;
    }
}
