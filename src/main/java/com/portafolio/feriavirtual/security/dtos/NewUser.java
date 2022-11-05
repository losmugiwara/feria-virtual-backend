package com.portafolio.feriavirtual.security.dtos;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewUser {

    @NotBlank
    private String userName;
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    private Set<String> roles = new HashSet<>();
    @NotBlank
    private String rut;
    @NotBlank
    private String businessName;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String commune;
    @NotBlank
    private String address;
    




    
}
