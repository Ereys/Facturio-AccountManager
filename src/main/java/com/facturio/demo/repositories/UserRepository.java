package com.facturio.demo.repositories;

import com.facturio.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findUserByName(String name);

    public List<AppUser> findUserByNameStartsWith(String pattern);
}