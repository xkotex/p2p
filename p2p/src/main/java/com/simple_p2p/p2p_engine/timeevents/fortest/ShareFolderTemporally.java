package com.simple_p2p.p2p_engine.timeevents.fortest;

import com.simple_p2p.p2p_engine.p2pcontrol.interfaces.P2PServerControl;
import com.simple_p2p.p2p_engine.server.Settings;

import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;

public class ShareFolderTemporally extends TimerTask {

    private P2PServerControl p2pServerControl;

    public ShareFolderTemporally() {
        this.p2pServerControl = Settings.getInstance().getSprAppCtx().getBean(P2PServerControl.class);
    }

    @Override
    public void run() {
        ArrayList<File> nodeArrayList = new ArrayList<>();
        File file = new File("D:\\nokia numbers");
        nodeArrayList.add(file);
        p2pServerControl.shareDirOrFiles(nodeArrayList);
    }
}
