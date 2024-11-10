package org.example.awss3exzample.client;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

@Configuration
@EnableScheduling
public class WebSocketClientConfig {

    private static final String URL = "ws://localhost:9090/ws"; // Server A URL

    private StompSession stompSession;

    @PostConstruct
    public void connect() {
        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        stompClient.connect(URL, new StompSessionHandlerAdapter() {
            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                stompSession = session;
                session.subscribe("/topic/commands", new MyStompFrameHandler()); // Xabarlarni olish
                System.out.println("Connected to Server A WebSocket");
            }
        });
    }

    public static class MyStompFrameHandler implements StompFrameHandler {
        @Override
        public Type getPayloadType(StompHeaders headers) {
            return String.class;
        }

        @Override
        public void handleFrame(StompHeaders headers, Object payload) {
            CommandsDto command = (CommandsDto) payload;
            System.out.println("Server B received: " + command);
        }
    }
}



