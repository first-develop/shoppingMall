package com.xzy.WebsocketTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ServerEndpoint(value = "/websocketTest/{userId}")//@ServerEndpoint把当前类变成websocket服务类
public class WebsocketTest {
    private Logger logger = LoggerFactory.getLogger(WebsocketTest.class);
    private static String userId;
    // 连接的用户
    private static Map<String, Session> onlines = new HashMap<String, Session>();

    // 连接时执行
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {
        this.userId = userId;
        onlines.put(userId, session);
        System.out.println("新连接：" + userId);

    }

    // 关闭时执行
    @OnClose
    public void onClose(@PathParam("userId") String userId) {
        if (onlines.containsKey(userId)) {
            onlines.remove(userId);
        }
        System.out.println("连接close：" + this.userId + " 关闭");
    }

    // 收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userId") String userId) throws IOException {
        System.out.println(message);
        if (message.contains("&")) {
            String[] params = message.split("&");
            if (params[1].equals("all")) {
                System.out.println("广播");
                sendMessageToAll(userId + "发送广播消息:" + params[0]);
            } else {
                System.out.println("toUser");
                sendMessageToUser(userId, params[1], params[0]);
                ;
            }
        }else
            session.getBasicRemote().sendText(userId+"发送消息： " + message);
        System.out.println(onlines.toString());
    }




    // 连接错误时执行
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("用户id为：" + this.userId + "的连接发送错误");
        error.printStackTrace();
    }

    /**
     * 广播消息给所有人
     * **/
    private void sendMessageToAll(String message) {
        Set<String> users = onlines.keySet();
        for (String user : users) {
            try {
                if (onlines.get(user).isOpen()) {
                    ((Session) onlines.get(user)).getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }
    /******
     *  给某个用户发送消息
     * @Param userName 发消息的name
     * **/
    private void sendMessageToUser(String userName, String receiveName, String message) {
        Set<String> users = onlines.keySet();
        for (String user : users) {
            if (user.equals(receiveName)) {
                try {
                    if (onlines.get(user).isOpen()) {
                        System.out.println("user---" + user);
                        ((Session) onlines.get(user)).getBasicRemote().sendText(userName + "给你发了消息：" + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
