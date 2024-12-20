package com.SpringProject.ChatApp.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class userEntity {
    
    @Id
    private String nickname;
    private String fullName;    
    private UserStatus status; 

}
