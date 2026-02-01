package com.security.springsecuritybasics.security;

import com.security.springsecuritybasics.repository.AttemptsRepository;
import com.security.springsecuritybasics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private static final int ATTEMPTS_LIMIT = 3;

    private final SecurityUserDetailsService securityUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AttemptsRepository attemptsRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {



        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
