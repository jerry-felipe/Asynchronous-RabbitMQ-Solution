package com.jerryfelipe.transactionmgmt.service;

import com.jerryfelipe.transactionmgmt.model.User;
import com.jerryfelipe.transactionmgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Registrar un nuevo usuario
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Obtener un usuario por su nombre de usuario
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
