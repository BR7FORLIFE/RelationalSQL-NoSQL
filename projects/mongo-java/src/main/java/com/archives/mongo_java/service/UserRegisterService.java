package com.archives.mongo_java.service;

import org.springframework.stereotype.Service;

import com.archives.mongo_java.command.RegisterUserCommand;
import com.archives.mongo_java.command.RegisterUserCommandResult;
import com.archives.mongo_java.models.UserModel;
import com.archives.mongo_java.repository.UserRepositoryAdapter;

import reactor.core.publisher.Mono;

@Service
public class UserRegisterService {

    private final UserRepositoryAdapter userRepositoryAdapter;

    public UserRegisterService(UserRepositoryAdapter userRepositoryAdapter) {
        this.userRepositoryAdapter = userRepositoryAdapter;
    }

    public Mono<RegisterUserCommandResult> register(RegisterUserCommand cmd) {
        return userRepositoryAdapter.findByName(cmd.name())
                .flatMap(exists -> Mono
                        .<RegisterUserCommandResult>error(new IllegalStateException("User already register!")))
                .switchIfEmpty(
                        userRepositoryAdapter.save(UserModel.createNew(cmd.name(), cmd.email()))
                                .map(result -> new RegisterUserCommandResult("User register succesfull!")));
    }
}
