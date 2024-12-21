package com.SpringProject.ChatApp.ChatMessages;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessagesRepository extends MongoRepository<ChatMessageEntity,String>{

    List<ChatMessageEntity> findAllByChatId(String chatId);
    
}
