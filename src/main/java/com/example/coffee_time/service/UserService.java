package com.example.coffee_time.service;
import com.example.coffee_time.entity.User;
import com.example.coffee_time.exception.EntityNotFoundException;
import com.example.coffee_time.repository.UserRepository;
import com.example.coffee_time.utils.MappingUtils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with id %s not found", id)));
    }

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // закодировать пароль от пользователя
        userRepository.save(user);
    }

    public void deleteById(Long id){ // переписать на DTO!!
        userRepository.deleteById(id);
    }

}
