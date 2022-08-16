package com.portafolio.feriavirtual.security.respositories;

import java.util.Optional;

import com.portafolio.feriavirtual.security.entities.Role;
import com.portafolio.feriavirtual.security.enums.RoleList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);
    
}
