package com.SpringProject.ChatApp.ChatMessages;

import org.springframework.stereotype.Service;

import com.SpringProject.ChatApp.ChatRoom.ChatRoomService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessagesService {

    private final ChatRoomService chatRoomService;
    private final ChatMessagesRepository messagesRepository;

    // TO FIX
    public ChatMessageEntity save(ChatMessageEntity chat) {
        var chatId = chatRoomService.getChatRoomId(chat.getReceiverId(),
                chat.getSenderId(),
                true);
        chat.setChatId((String) chatId);

        return null;
    }
}
