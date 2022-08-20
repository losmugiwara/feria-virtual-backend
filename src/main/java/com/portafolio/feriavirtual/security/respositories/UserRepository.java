package com.portafolio.feriavirtual.security.respositories;

import java.util.Optional;

import com.portafolio.feriavirtual.security.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    
}
