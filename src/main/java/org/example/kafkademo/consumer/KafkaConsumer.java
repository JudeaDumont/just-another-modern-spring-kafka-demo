package org.example.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.kafkademo.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "test", groupId = "myGroup")
    public void consume(Student msg) {
        log.info(String.format("Consumed message: %s", msg.toString()));
    }
}
