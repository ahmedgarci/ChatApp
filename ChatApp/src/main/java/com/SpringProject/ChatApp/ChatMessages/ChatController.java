package com.SpringProject.ChatApp.ChatMessages;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class ChatController {
    private final MessagesService messagesService;    
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void ProcessMessage(@Payload ChatMessageEntity chatmessage){
        ChatMessageEntity message = messagesService.save(chatmessage);
        messagingTemplate.convertAndSendToUser(chatmessage.getSenderId() ,
         chatmessage.getReceiverId(), message);
    }


    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<ChatMessageEntity>> findChatMessages(
        @PathVariable String senderId,
        @PathVariable String receiverId
        ) {
        return ResponseEntity.ok(messagesService.findAllMessages(receiverId, senderId));
    }
    

}
