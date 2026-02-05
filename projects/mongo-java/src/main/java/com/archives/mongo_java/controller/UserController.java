package com.archives.mongo_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.mongo_java.command.RegisterUserCommand;
import com.archives.mongo_java.dtos.request.UserRegisterRequestDto;
import com.archives.mongo_java.dtos.response.UserRegisterResponseDto;
import com.archives.mongo_java.service.UserRegisterService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRegisterService userService;

    public UserController(UserRegisterService userRegisterService) {
        this.userService = userRegisterService;
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<UserRegisterResponseDto>> register(@Valid @RequestBody UserRegisterRequestDto dto) {
        RegisterUserCommand cmd = new RegisterUserCommand(dto.name(), dto.email());

        return userService.register(cmd)
                .map(result -> ResponseEntity.ok(
                        new UserRegisterResponseDto(result.message())));
    }
}
