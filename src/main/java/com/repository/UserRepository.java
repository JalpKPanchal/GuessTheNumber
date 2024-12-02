package com.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}