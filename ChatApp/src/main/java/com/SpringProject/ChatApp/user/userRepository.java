package com.SpringProject.ChatApp.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<userEntity,String> {

    List<userEntity> findAllByStatus(UserStatus staus);
    

}
