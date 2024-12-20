package com.SpringProject.ChatApp.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userService {

    private final userRepository userRepository;

    public void SaveUser(userEntity user){
        user.setStatus(UserStatus.ONLINE);
        userRepository.save(user);
    }   

    public void Disconnect(userEntity user){
        var storedUser = userRepository.findById(user.getNickname())
        .orElse(null);
        if( storedUser != null){
            storedUser.setStatus(UserStatus.OFFLINE);
            userRepository.save(storedUser);
        }

    }
    
    public List<userEntity> getConnectedUsers(){
        return userRepository.findAllByStatus(UserStatus.ONLINE);
    }

}
