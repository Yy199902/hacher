package com.pay.lcnorder.service.impl;

import com.pay.lcnorder.dao.EventDao;
import com.pay.lcnorder.entity.Event;
import com.pay.lcnorder.service.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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