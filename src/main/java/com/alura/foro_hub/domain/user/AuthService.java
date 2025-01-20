package com.alura.foro_hub.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alura.foro_hub.dto.user.AuthResponseDto;
import com.alura.foro_hub.dto.user.UserSigninRequestDto;
import com.alura.foro_hub.dto.user.UserSignupRequestDto;
import com.alura.foro_hub.infra.error.AuthException;
import com.alura.foro_hub.infra.security.TokenService;

@Service
@Configuration
public class AuthService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  public AuthResponseDto register(UserSignupRequestDto userSignup) {
    var userFound = userRepository.findByEmail(userSignup.email());
    if(userFound.isPresent()){
      throw new AuthException("User with this email already exists, please login.");
    }

    var newUser = new User(userSignup.name(), userSignup.email(), passwordEncoder.encode(userSignup.password()));
    var user = userRepository.save(newUser);
    var token = tokenService.createToken(user);

    return new AuthResponseDto(user, token);
  }

  public AuthResponseDto login(UserSigninRequestDto userSignin) {
    var userPasswordAuthToken = new UsernamePasswordAuthenticationToken(userSignin.email(), userSignin.password());
    var userAuth = authenticationManager.authenticate(userPasswordAuthToken);
    var user = (User) userAuth.getPrincipal();
    var token = tokenService.createToken(user);

    return new AuthResponseDto(user, token);
  }
}
