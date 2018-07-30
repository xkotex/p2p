package com.simple_p2p.controller;

import com.simple_p2p.entity.MessageTable;
import com.simple_p2p.model.ChatMessage;
import com.simple_p2p.p2p_engine.p2pcontrol.interfaces.P2PServerControl;
import com.simple_p2p.repository.MessageTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;


@Controller
public class ChatController {

    private String userHash;

    @Autowired
    private P2PServerControl p2PServerControl;

    private MessageTableRepository messageTableRepository;

    public ChatController(MessageTableRepository messageTableRepository){
        this.messageTableRepository = messageTableRepository;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        saveMessageToTable(chatMessage.getSender(), chatMessage.getContent());
        p2PServerControl.sendMessageToAllConnect(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }


    private void saveMessageToTable(String username, String message){
        //System.out.println("DAOOOOOOOOOOOOOOOOOO");
        MessageTable messageTable = new MessageTable();
        messageTable.setCreated(LocalDateTime.now());
        messageTable.setUserName(username);
        messageTable.setMessage(message);
        messageTableRepository.save(messageTable);
    }
}
