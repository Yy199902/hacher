package com.pay.lcnpay.service.impl;


import com.pay.lcnpay.dao.EventDao;
import com.pay.lcnpay.entity.Event;
import com.pay.lcnpay.service.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Event)表服务实现类
 *
 * @author makejava
 * @since 2020-12-06 19:01:35
 */
@Service("eventService")
public class EventServiceImpl implements EventService {
    @Resource
    private EventDao eventDao;

    @Override
    public void insert(Event event) {
         eventDao.insert(event);
    }


}