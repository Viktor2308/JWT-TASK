package com.github.viktor2308.jwttask.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.viktor2308.jwttask.dto.LoginRequest;
import com.github.viktor2308.jwttask.dto.JwtResponse;
import com.github.viktor2308.jwttask.entity.User;
import com.github.viktor2308.jwttask.repository.UserRepository;
import com.github.viktor2308.jwttask.service.AuthService;
import com.github.viktor2308.jwttask.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public Optional<JwtResponse> login(LoginRequest loginRequest) {
      Optional<User> currentUser = userRepository.findUserByUsername(loginRequest.getName());

      if(currentUser.isEmpty()){
          log.error("User not found!");
          return Optional.empty();
      }

        BCrypt.Result result = BCrypt.verifyer().verify(loginRequest.getPassword().toCharArray(), currentUser.get().getPassword());

      if(!result.verified){
          log.error("Wrong password!");
          return Optional.empty();
      }


        String token = jwtService.generateJwtToken(loginRequest.getName());


        return Optional.of(JwtResponse.builder().token(token).build());
    }
}
