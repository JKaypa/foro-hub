package com.alura.foro_hub.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alura.foro_hub.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


@Service
public class TokenService {

  @Value("${token.security.secret}")
  private String secret;

  private static final String ISSUER = "foro_hub";

  public String createToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer(ISSUER)
          .withSubject(user.getEmail())
          .withClaim("id", user.getId())
          .withExpiresAt(generateExpirationDate())
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Token was not created");
    }
  }

  public DecodedJWT verifyToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .withIssuer(ISSUER)
          .build()
          .verify(token);

    } catch (JWTVerificationException exception) {
      throw new RuntimeException("Token is not valid");
    }
  }

  private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-05:00"));
    }
}
