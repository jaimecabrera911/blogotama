package com.blogoramaapi.infrastructure.security.services;

import com.blogoramaapi.domain.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityRepository.findByUsername(username).orElseThrow();
    }
}
