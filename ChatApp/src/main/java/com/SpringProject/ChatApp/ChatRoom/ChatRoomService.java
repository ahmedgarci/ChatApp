package com.SpringProject.ChatApp.ChatRoom;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRepository chatRepository;
    
    public Optional<String> getChatRoomId(String receiverId,String SenderId,boolean chatRoomExists){
        return chatRepository.findByReceiverIdAndSenderId(receiverId,SenderId)
            .map(ChatRoomEntity::getId)
            .or(()-> {
                if(chatRoomExists){
                    var chatId = createNewChatRoom(SenderId,receiverId);
                    return Optional.of(chatId);
                }
                return Optional.empty();
            })
        
        ;
    }
    
    private String createNewChatRoom(String SenderId, String receiverId){
        String chatId = String.format("%s_%s", SenderId,receiverId);
        ChatRoomEntity SenderReceiverChat = ChatRoomEntity
            .builder()
            .chatId(chatId)
            .senderId(SenderId)
            .receiverId(receiverId)
        .build();

        ChatRoomEntity receiverSenderChat = ChatRoomEntity
        .builder()
        .chatId(chatId)
        .senderId(receiverId)
        .receiverId(SenderId)
    .build();

        chatRepository.save(SenderReceiverChat);
        chatRepository.save(receiverSenderChat);
        return chatId;
    }


}
