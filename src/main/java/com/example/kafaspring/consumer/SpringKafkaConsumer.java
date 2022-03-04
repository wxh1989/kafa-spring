package com.example.kafaspring.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class SpringKafkaConsumer {

    /**
     * 处理单挑消息
     * @param record
     * @param ack
     */
    @KafkaListener(topics = "kafka-spring-topic",groupId = "group-kafka-spring")
    private void listenerTopic(ConsumerRecord<String,String> record, Acknowledgment ack){
        System.out.println(record.value());
        System.out.println(record.toString());
        ack.acknowledge();

    }

    /**
     * 一批一批处理消息
     * @param records
     * @param ack
     */
    @KafkaListener(topics = "kafka-spring-topic",groupId = "group-kafka-spring")
    private void listenerTopicBatch(ConsumerRecords<String,String> records, Acknowledgment ack){
        records.forEach(record -> {
           System.out.println(record.value());
        });
        ack.acknowledge();

    }
}
