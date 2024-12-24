package com.jerryfelipe.transactionmgmt.controller;

import com.jerryfelipe.transactionmgmt.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitmqController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam String messageContent) {
        rabbitmqService.saveMessage(messageContent);
    }

    @PostMapping("/logEvent")
    public void logEvent(@RequestParam String eventType, @RequestParam String eventMessage) {
        rabbitmqService.logRabbitmqEvent(eventType, eventMessage);
    }
}
