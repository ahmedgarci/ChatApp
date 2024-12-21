package com.SpringProject.ChatApp.ChatMessages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringProject.ChatApp.ChatRoom.ChatRoomService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessagesService {

    private final ChatRoomService chatRoomService;
    private final ChatMessagesRepository messagesRepository;

    public ChatMessageEntity save(ChatMessageEntity message) {
        var chatId = chatRoomService.getChatRoomId(message.getReceiverId(),
                message.getSenderId(),
                true);
        message.setChatId(chatId.get());
        messagesRepository.save(message);
        return message;
    }
    public List<ChatMessageEntity> findAllMessages(String receiverId,String senderId){
        var chatId = chatRoomService.getChatRoomId(receiverId, senderId, false);
        return chatId.map(messagesRepository::findAllByChatId).orElse(new ArrayList<>());
    }
}
