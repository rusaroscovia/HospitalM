package com.springboot.example.springbootappllication.Auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public OAuth2SuccessHandler(UserRepository userRepository,
                                UserDetailsServiceImpl userDetailsService,
                                JwtUtil jwtUtil,
                                PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String email = oauth2User.getAttribute("email");

        // create user in DB if first time
        userRepository.findByUsername(email).orElseGet(() -> {
            User newUser = new User(email, passwordEncoder.encode(UUID.randomUUID().toString()), Set.of("ROLE_USER"));
            return userRepository.save(newUser);
        });

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        String token = jwtUtil.generateToken(userDetails);

        // return token in response body
        response.setContentType("application/json");
        response.getWriter().write("{\"token\":\"" + token + "\"}");
    }
}
