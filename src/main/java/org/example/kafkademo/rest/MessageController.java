package org.example.kafkademo.rest;

import lombok.RequiredArgsConstructor;
import org.example.kafkademo.payload.Student;
import org.example.kafkademo.producer.KafkaJsonProducer;
import org.example.kafkademo.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaJsonProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<Student> sendMessage(@RequestBody Student message) {

        kafkaProducer.send(message);
        return ResponseEntity.ok(message);
    }
}
