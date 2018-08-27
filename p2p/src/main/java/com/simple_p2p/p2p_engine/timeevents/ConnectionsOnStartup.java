package com.simple_p2p.p2p_engine.timeevents;

import com.simple_p2p.p2p_engine.Message.MessageFactory;
import com.simple_p2p.p2p_engine.p2pcontrol.interfaces.P2PServerControl;
import com.simple_p2p.p2p_engine.server.Settings;
import io.netty.channel.group.ChannelGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class ConnectionsOnStartup extends TimerTask{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ConnectionsOnStartup(){
    }
    @Override
    public void run() {
        String address1 = "192.168.0.1";
        logger.info("Try to connect to " +address1);
        Settings settings = Settings.getInstance();
        P2PServerControl p2PServerControl = settings.getSprAppCtx().getBean(P2PServerControl.class);
        p2PServerControl.connectTo(address1);
    }
}
