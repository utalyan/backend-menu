package com.restaurant.menu.service;

import com.restaurant.menu.entity.User;
import com.restaurant.menu.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder,UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void create(User user) {

        String passwordEncoded = passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordEncoded);

        userRepository.save(user);
    }

    public User findUserByusername(String username)
    {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent())
        {
            throw  new UsernameNotFoundException("Kullanıcı Bulunamadı...");
        }
        return user.get();
    }

    public  User findById(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new UsernameNotFoundException("Kullanıcı Bulunamadı...");
        }

        return user.get();
    }
}
