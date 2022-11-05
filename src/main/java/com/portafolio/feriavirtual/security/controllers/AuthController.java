package com.portafolio.feriavirtual.security.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.portafolio.feriavirtual.entities.Message;
import com.portafolio.feriavirtual.security.dtos.JwtDto;
import com.portafolio.feriavirtual.security.dtos.LoginUser;
import com.portafolio.feriavirtual.security.dtos.NewUser;
import com.portafolio.feriavirtual.security.entities.Role;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.enums.RoleList;
import com.portafolio.feriavirtual.security.jwt.JwtProvider;
import com.portafolio.feriavirtual.security.services.RoleService;
import com.portafolio.feriavirtual.security.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtProvider jwtProvider;
    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder,
            UserService userService, RoleService roleService, JwtProvider jwtProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
        this.jwtProvider = jwtProvider;
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult){
        if(bidBindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        try {
                UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword());
                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(authentication);
                JwtDto jwtDto = new JwtDto(jwt);
                return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
                return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<Object> resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
            
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        Set<Role> roles = new HashSet<>();
        if (newUser.getRoles().contains("ROLE_CUSTOMER_EXTERNAL"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_CUSTOMER_EXTERNAL).get());
        if (newUser.getRoles().contains("ROLE_ADMIN"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_ADMIN).get());
        user.setRoles(roles);


        if(userService.save(user)){
            return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Message("Credenciales en uso, intenta con otro usuario o email"), HttpStatus.OK);
        
        
        
        
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register/account")
    public ResponseEntity<Object> resgisterAccount(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        
            User user = new User();
            user.setUserName(newUser.getUserName());
            user.setEmail(newUser.getEmail());
            user.setPassword(passwordEncoder.encode(newUser.getPassword()));
            user.setName(newUser.getName());
            user.setLastName(newUser.getLastName());
            user.setRut(newUser.getRut());
            user.setBusinessName(newUser.getBusinessName());
            user.setCountry(newUser.getCountry());
            user.setCity(newUser.getCity());
            user.setCommune(newUser.getCommune());
            user.setAddress(newUser.getAddress());
        
                Set<Role> roles = new HashSet<>();
        if (newUser.getRoles().contains("ROLE_CUSTOMER_EXTERNAL"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_CUSTOMER_EXTERNAL).get());
        if (newUser.getRoles().contains("ROLE_CUSTOMER_INTERNAL"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_CUSTOMER_INTERNAL).get());
        if (newUser.getRoles().contains("ROLE_CONSULTANT"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_CONSULTANT).get());
        if (newUser.getRoles().contains("ROLE_CARRIER"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_CARRIER).get());
        if (newUser.getRoles().contains("ROLE_PRODUCER"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_PRODUCER).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Message("Usuario creado con exito!"), HttpStatus.CREATED);
    }


    @GetMapping("/profile/{userName}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String userName){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getByUserName(userName));
    } 

}
