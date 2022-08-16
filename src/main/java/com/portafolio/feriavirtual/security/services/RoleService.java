package com.portafolio.feriavirtual.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.portafolio.feriavirtual.security.respositories.RoleRepository;
import com.portafolio.feriavirtual.security.entities.Role;
import com.portafolio.feriavirtual.security.enums.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<Role> getByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }
    
    
}
