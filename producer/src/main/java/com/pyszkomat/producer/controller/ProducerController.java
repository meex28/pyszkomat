package com.pyszkomat.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ProducerController {

    private final SqsClient sqsClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${sqs.queue.url}")
    private String queueUrl;

    public ProducerController(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Map<String, Object> payload) throws JsonProcessingException {
        String messageBody = objectMapper.writeValueAsString(payload);

        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)
                .build());

        System.out.println("Sent message:");
        System.out.println(messageBody);

        return "Message sent!";
    }
}
