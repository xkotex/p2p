package com.p2p.p2p_engine.p2pcontrol.interfaces;

import com.p2p.model.ChatMessage;

public interface P2PServerControl {
    void sendMessageToAllConnect(ChatMessage chatMessage);

}
