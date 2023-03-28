package com.facturio.demo.repositories;

import com.facturio.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByName(String name);
    public User findUsersById(String id);
    public List<User> findUserByNameStartsWith(String pattern);
}