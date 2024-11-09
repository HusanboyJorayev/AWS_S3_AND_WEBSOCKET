package org.example.awss3exzample.controller;


import lombok.RequiredArgsConstructor;
import org.example.awss3exzample.DatchikDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    @MessageMapping("/getAllWeighingResponse")
    @SendTo("/topic/weighing")
    public List<Integer> getAllWeighingResponse() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            list.add(random.nextInt(1, 30));
        }
        return list;
    }

    @MessageMapping("/getOneDatchikWhereCreatedAtDec")
    @SendTo("/topic/sensor")
    public DatchikDto getOneDatchikWhereCreatedAtDec() {
        Random random = new Random();
        return DatchikDto.builder()
                .scaleId(1)
                .controller(random.nextBoolean())
                .gate1(random.nextBoolean())
                .gate2(random.nextBoolean())
                .camera1(random.nextBoolean())
                .camera2(random.nextBoolean())
                .camera3(random.nextBoolean())
                .sensor1(random.nextBoolean())
                .sensor2(random.nextBoolean())
                .sensor3(random.nextBoolean())
                .build();
    }
}
