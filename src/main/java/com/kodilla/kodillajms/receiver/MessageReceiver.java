package com.kodilla.kodillajms.receiver;

import com.kodilla.kodillajms.domain.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(containerFactory = "jmsFactory", destination = "queue_order")
    public void receive(Order mapOrder){
        System.out.println("Received order: " + mapOrder.getItemName());
    }
}
