package com.springboot.example.springbootappllication.Auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            userRepository.save(new User("admin", passwordEncoder.encode("admin123"), Set.of("ROLE_ADMIN")));
        }
        if (userRepository.findByUsername("user").isEmpty()) {
            userRepository.save(new User("user", passwordEncoder.encode("user123"), Set.of("ROLE_USER")));
        }
    }
}
