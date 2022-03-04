package com.example.kafaspring.contraller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {

    private final String STRING_TOPIC = "kafka-spring-topic";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping(method = RequestMethod.POST,value = "/send")
    public void sendMessage(@RequestParam(value = "message")String message){
        kafkaTemplate.send(STRING_TOPIC,message);
    }
}
