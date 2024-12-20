package com.SpringProject.ChatApp.ChatRoom;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<ChatRoomEntity,String> {

    Optional<ChatRoomEntity> findByReceiverIdAndSenderId(String receiverId, String senderId);
    
}
