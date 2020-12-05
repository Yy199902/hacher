package com.pay.order.controller;

import com.pay.order.entry.Event;
import com.pay.order.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public Event event(String id){
        return eventService.findById(id);
    }
}
