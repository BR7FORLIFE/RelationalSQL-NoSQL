package com.archives.mongo_java.repository;

import org.springframework.stereotype.Repository;

import com.archives.mongo_java.models.UserModel;
import com.archives.mongo_java.repository.mongo.IUserRepository;

import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryAdapter {

    private final IUserRepository userRepository;

    public UserRepositoryAdapter(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<UserModel> findByName(String name) {
        return userRepository.findByName(name);
    }

    public Mono<UserModel> save(UserModel user) {
        return userRepository.save(user);
    };
}
