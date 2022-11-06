package com.portafolio.feriavirtual.security.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users") 
@Getter
@Setter
@AllArgsConstructor

public class User {


    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userid_generator")
//    @SequenceGenerator(name = "userid_generator", initialValue = 1, allocationSize = 1, sequenceName = "userid_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NaturalId
    @Column(unique = true)
    private String userName;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "last_name")
    @NotNull
    private String lastName;
    @NotNull
    @Email
    @Column(length = 100)
    private String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role_relate", joinColumns = @JoinColumn(name="user_id"),
     inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "rut", length = 15)
    private String rut;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "commune")
    private String commune;


    @Column(name = "address")
    private String address;
    @Null
    @Column(name = "birth_date")
    private Date birthDate;
    

    public User() {
    }

    public User(@NotNull String userName, @NotNull String email, @NotNull String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
