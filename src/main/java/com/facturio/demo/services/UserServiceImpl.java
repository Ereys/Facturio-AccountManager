package com.facturio.demo.services;

import com.facturio.demo.dtos.UserDtoRequest;
import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.repositories.UserRepository;
import com.facturio.demo.securities.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface, UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomPasswordEncoder encoder;

    @Override
    public AppUser AddUser(AppUser newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        System.out.println(newUser.toString());
        return this.userRepository.save(newUser);
    }
    @Override
    public void setUserRole(AppUser user, Role role) {
        AppUser target = this.userRepository.findByEmail(user.getEmail()).orElse(null);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser foundUser = this.userRepository.findByEmail(username).orElse(null);
        if(foundUser == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(foundUser.getRole().name()));
        System.out.println(foundUser.toString());
        return new User(foundUser.getEmail(), foundUser.getPassword(), authorities);
    }
}
