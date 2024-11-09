package org.example.awss3exzample.config;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class YourWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Mijoz WebSocketga ulanishi o'rnatilganda bajariladigan kod
        System.out.println("WebSocket connection established: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Mijozdan xabar kelganda bajariladigan kod
        String clientMessage = message.getPayload();
        System.out.println("Received message: " + clientMessage);

        // Javob xabarini yuborish
        session.sendMessage(new TextMessage("Echo: " + clientMessage));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // Transport xatolari bo'lsa bajariladigan kod
        System.err.println("Error in WebSocket connection: " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Mijoz WebSocket ulanishini yopganda bajariladigan kod
        System.out.println("WebSocket connection closed: " + session.getId());
    }
}

