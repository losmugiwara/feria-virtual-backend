package com.portafolio.feriavirtual.security.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users") 
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    private Long id;
    @NotNull
    @NaturalId
    @Column(unique = true)
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role_relate", joinColumns = @JoinColumn(name="user_id"),
     inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();
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
