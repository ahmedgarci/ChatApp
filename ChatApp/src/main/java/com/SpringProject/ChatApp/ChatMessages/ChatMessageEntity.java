package com.SpringProject.ChatApp.ChatMessages;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ChatMessageEntity {
    @Id
    private String id;
    private String chatId;
    private String receiverId;
    private String senderId;
    private String content;
    private Date timestamp;
    
}
