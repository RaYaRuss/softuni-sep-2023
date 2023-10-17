package com.likebookapp.service.impl;

import com.likebookapp.model.UserRegisterDTO;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            return false;
        }

        String username = userRegisterDTO.getUsername();

        if (this.userRepository.findByUsername(username) !=null) {
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setEmail(userRegisterDTO.getEmail());

        this.userRepository.save(user);
        return true;
    }
}
