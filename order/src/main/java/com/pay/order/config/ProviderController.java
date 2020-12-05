package com.pay.order.config;

import com.pay.order.dao.EventDao;
import com.pay.order.entry.Event;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import javax.json.JsonObject;

@Component
public class ProviderController {
    //注入存放消息的队列，用于下列方法一
    @Autowired
    private Queue queue;
    @Autowired
    private EventDao eventDao;

    //注入springboot封装的工具类
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(cron = "*/5 * * * * ?")
    @Transactional
    public void send() {
        //方法一：添加消息到消息队列
        Event event = eventDao.findById("1");
        if (event!=null){
            eventDao.updateType(event.getId());
            System.out.println(event);
            jmsMessagingTemplate.convertAndSend(queue, JSONObject.fromObject(event).toString());

        }

        System.out.println("执行任务");


    }

}
