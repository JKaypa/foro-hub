package com.alura.foro_hub.domain.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro_hub.dto.user.AuthResponseDto;
import com.alura.foro_hub.dto.user.UserSigninRequestDto;
import com.alura.foro_hub.dto.user.UserSignupRequestDto;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("auth")
public class AuthController {
  @Autowired
  private AuthService authService;


  @PostMapping("signup")
  public ResponseEntity<AuthResponseDto> signup(@RequestBody @Valid UserSignupRequestDto userSignup) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(userSignup));
  }

  @PostMapping("signin")
  public ResponseEntity<AuthResponseDto> signin(@RequestBody @Valid UserSigninRequestDto userSignin) {
    return ResponseEntity.ok(authService.login(userSignin));
  }
  

}
