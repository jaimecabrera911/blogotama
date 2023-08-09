package com.blogoramaapi.infrastructure.security.services;

import com.blogoramaapi.application.dtos.req.UserReqDto;
import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.application.mappers.UserMapper;
import com.blogoramaapi.application.usecases.users.FindUsersUseCase;
import com.blogoramaapi.domain.entities.UserEntity;
import com.blogoramaapi.domain.repositories.UserEntityRepository;
import com.blogoramaapi.infrastructure.security.dtos.AuthReqDto;
import com.blogoramaapi.infrastructure.security.dtos.AuthResDto;
import com.blogoramaapi.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImp implements AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final UserEntityRepository userEntityRepository;
    private final FindUsersUseCase findUsersUseCase;

    @Override
    public AuthResDto login(AuthReqDto authReqDto) {
        UserResDto user = findUsersUseCase.findByUsernameOrEmail(
                authReqDto.getUsername()
        );
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), authReqDto.getPassword())
        );
        UserEntity principal = (UserEntity) authenticate.getPrincipal();
        return new AuthResDto(jwtService.generateToken(principal));
    }

    @Override
    public void singUp(UserReqDto userReqDto) {
        UserEntity userEntity = userMapper.toEntity(userReqDto);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        userEntity.setEnabled(true);
        userEntityRepository.save(userEntity);
    }
}
