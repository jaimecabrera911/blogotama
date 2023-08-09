package com.blogoramaapi.infrastructure.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.application.usecases.users.FindUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    @Value("${app.jwt.secret}")
    private String jwtSigningKey;
    private final FindUsersUseCase findUsersUseCase;

    private final Instant expirationTime = Instant.now().plus(30, ChronoUnit.MINUTES);

    @Override
    public String extractUserName(String token) {
        return getDecode(token).getSubject();
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        String username = userDetails.getUsername();
        UserResDto userResDto = findUsersUseCase.findByUsernameOrEmail(username);
        return JWT.create()
                .withIssuer("blogorama-api")
                .withSubject(username)
                .withClaim("email", userResDto.getEmail())
                .withClaim("permissions", getPermissions(userDetails))
                .withClaim("registrationDate", userResDto.getRegistrationDate())
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(expirationTime))
                .sign(Algorithm.HMAC512(jwtSigningKey));
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        Algorithm algorithm = Algorithm.HMAC512(jwtSigningKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("blogorama-api") // Verifica el emisor del token
                .build();
        verifier.verify(token);
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractAllClaims(token).get("exp").asDate();
    }

    private Map<String, Claim> extractAllClaims(String token) {
        return getDecode(token).getClaims();
    }

    private static DecodedJWT getDecode(String token) {
        if (StringUtils.startsWith(token, "Bearer")) token = token.replace("Bearer ", "");
        return JWT.decode(token);
    }

    private List<String> getPermissions(UserDetails userDetails) {
        return userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }
}
