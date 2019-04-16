package com.hms.application.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.application.entity.infoMessage;
import com.hms.application.service.MessageService;
import com.hms.application.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

//用法相当于Controller localhost:8080/websocket
@ServerEndpoint(value = "/websocket/{code}")
@Component
public class WebSocket {
    public static MessageService messageService;
    //静态变量，用来记录当前在线连接数。把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    //把客户端session和用户编码关联起来
    private static ConcurrentHashMap<Integer, WebSocket> webSocketMap = new ConcurrentHashMap<Integer, WebSocket>();
    private int userId = 0;
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * 连接时会自动调用
     */
    @OnOpen
    public void onOpen(@PathParam(value = "code")int code, Session session) {
        this.session = session;
        userId = code;
        //将链接进来的客户端session放入map中
        webSocketMap.put(code,this);
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount()+"，连接的用户编码为"+userId);
//        try {
//            sendMessage("连接成功");
//        } catch (IOException e) {
//            System.out.println("IO异常");
//        }
    }

    /**
     * 连接关闭调用的方法
     * 关闭时会自动调用
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        webSocketMap.remove(userId);   //从map中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount()+"，断开连接的用户编码为"+userId);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     *                客户端向服务端主动发送消息时调用
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);

        //群发消息
//        for (WebSocket item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        sendToUser(message);
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    //向客户端推送消息
    public void sendMessage(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * 可以在controller中调用该方法来实时推送消息
     */
    public static void sendInfo(String message) throws IOException {
        for (WebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    /**
     * 给指定的人发送消息
     * @param message
     */
    private void sendToUser(String message) {
//        infoMessage infoMessage = JSON.parseObject(message, com.hms.application.entity.infoMessage.class);
        JSONObject object = JSON.parseObject(message);

        try {
            int id;

            if("0".equals(object.get("mFromUserStyle"))){
                id = object.getIntValue("pkUser");
            }
            else{
                id = object.getIntValue("pkDoc");
            }
            //先把 消息保存进数据库
            infoMessage newMessage = new infoMessage();
            newMessage.setpkUser(object.getIntValue("pkUser"));//从消息中提取pkUser
            newMessage.setpkDoc(object.getIntValue("pkDoc"));//从消息中提取pkDoc
            newMessage.setmFromUserStyle(object.getString("mFromUserStyle"));//从消息中提取消息来源
            newMessage.setmToUserStyle(object.getString("mToUserStyle"));//从消息中提取消息去向
            newMessage.setmMessage(object.getString("mMessage"));
            newMessage.setmTime(object.getString("mTime"));
            messageService.insert(newMessage);
            //如果消息去向在线，则直接将消息推送过去
            if (webSocketMap.get(id) != null) {
                webSocketMap.get(id).sendMessage(message);
            }
            //如果不在线，则不推送，并且控制台输出不在线提示
            else {
                System.out.println("当前用户不在线");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
