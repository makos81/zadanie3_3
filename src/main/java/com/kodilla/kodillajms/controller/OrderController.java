package com.kodilla.kodillajms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.kodillajms.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void acceptOrder(@RequestBody String order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Order value = mapper.readValue(order, Order.class);

        jmsTemplate.convertAndSend("queue_order", value);
    }
}
