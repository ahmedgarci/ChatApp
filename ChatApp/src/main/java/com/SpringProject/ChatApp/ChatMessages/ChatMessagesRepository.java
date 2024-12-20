package com.SpringProject.ChatApp.ChatMessages;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessagesRepository extends MongoRepository<ChatMessageEntity,String>{
    
}
