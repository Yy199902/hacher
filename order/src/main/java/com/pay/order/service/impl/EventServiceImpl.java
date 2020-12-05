package com.pay.order.service.impl;

import com.pay.order.dao.EventDao;
import com.pay.order.entry.Event;
import com.pay.order.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;
    @Override
    public Event findById(String id) {
        return eventDao.findById(id);
    }
}
