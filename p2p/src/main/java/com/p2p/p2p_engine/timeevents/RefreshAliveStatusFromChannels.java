package com.p2p.p2p_engine.timeevents;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.AttributeKey;

import java.util.TimerTask;

public class RefreshAliveStatusFromChannels extends TimerTask{

    private ChannelGroup channelGroup;
    private AttributeKey<Boolean> isAlive = AttributeKey.newInstance("isAlive");

    public RefreshAliveStatusFromChannels(ChannelGroup channelGroup){
        this.channelGroup=channelGroup;
    }
    @Override
    public void run() {
        for(Channel c:channelGroup){
            if(c.hasAttr(isAlive)){
                c.attr(isAlive).set(false);
            }else {
                c.attr(isAlive).set(true);
            }
        }
    }
}
