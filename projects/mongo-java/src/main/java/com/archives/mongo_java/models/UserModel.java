package com.archives.mongo_java.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class UserModel {

    @Id
    private String id;
    private String name;
    private String email;

    public UserModel(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static UserModel createNew(String name, String email) {
        return new UserModel(UUID.randomUUID().toString(), name, email);
    }
}
