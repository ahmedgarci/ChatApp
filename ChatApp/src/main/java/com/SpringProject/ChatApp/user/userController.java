package com.SpringProject.ChatApp.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class userController {
    
    private final userService userService;


    @MessageMapping("/user.add_new_user")
    @SendTo("/user/topic")
    public userEntity addUser(
        @Payload userEntity user
        ){
        userService.SaveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnect_user")
    @SendTo("/user/topic")
    public userEntity disconnectUser(
        @Payload userEntity user
        ){
            userService.Disconnect(user);
            return user;
    }

    @GetMapping("/getConnectedUsers")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public ResponseEntity<List<userEntity>> getConnectedUsers(){
        return ResponseEntity.ok(userService.getConnectedUsers());
    }







}
