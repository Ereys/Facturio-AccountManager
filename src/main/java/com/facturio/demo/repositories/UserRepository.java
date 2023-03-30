package com.facturio.demo.repositories;

import com.facturio.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findUserByName(String name);

    Optional<AppUser> findByEmail(String email);

    public List<AppUser> findUserByNameStartsWith(String pattern);
}
