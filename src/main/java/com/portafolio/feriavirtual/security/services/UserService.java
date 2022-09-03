package com.portafolio.feriavirtual.security.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    public boolean existByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }
    public Boolean save(User user){

        Optional<User> userOptionalEmail = userRepository.findUserByEmail(user.getEmail());
        Optional<User> userOptionalUserName = userRepository.findByUserName(user.getUserName());

        if (userOptionalEmail.isPresent()) {
            return false;
        }
        if (userOptionalUserName.isPresent()) {
            return false;
        }

        userRepository.save(user);
        return true;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
}
