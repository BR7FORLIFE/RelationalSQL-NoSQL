package com.archives.mongo_java.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.archives.mongo_java.models.UserModel;

import reactor.core.publisher.Mono;

public interface IUserRepository extends ReactiveMongoRepository<UserModel, String>{
    Mono<UserModel> findByName(String name);
}
