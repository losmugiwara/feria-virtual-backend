package com.portafolio.feriavirtual.security.respositories;

import java.util.Optional;

import com.portafolio.feriavirtual.security.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    boolean existsByUserName(String userName);

    
}
