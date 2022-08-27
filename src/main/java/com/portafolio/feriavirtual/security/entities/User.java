package com.portafolio.feriavirtual.security.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users") 
@Getter
@Setter
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userid_generator")
    @SequenceGenerator(name = "userid_generator", initialValue = 1, allocationSize = 1, sequenceName = "userid_seq")
    private Long id;
    @NotNull
    @NaturalId
    @Column(unique = true)
    private String userName;
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

    @Null
    @Column(name = "rut", length = 15)
    private String rut;

    @Null
    @Column(name = "business_name")
    private String businessName;

    @Null
    @Column(name = "country", nullable = true)
    private String country;

    @Null
    @Column(name = "city", nullable = true)
    private String city;

    @Null
    @Column(name = "commune", nullable = true)
    private String commune;

    @Null
    @Column(name = "address", nullable = true)
    private String address;




    public User() {
    }

    public User(@NotNull String userName, @NotNull String email, @NotNull String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
