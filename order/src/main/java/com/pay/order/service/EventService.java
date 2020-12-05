package com.pay.order.service;

import com.pay.order.entry.Event;

public interface EventService {
    Event findById(String id);
}
