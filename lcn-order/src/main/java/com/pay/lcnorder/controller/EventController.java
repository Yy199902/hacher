package com.pay.lcnorder.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.pay.lcnorder.entity.Event;
import com.pay.lcnorder.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * (Event)表控制层
 *
 * @author makejava
 * @since 2020-12-06 19:01:35
 */
@RestController
@RequestMapping("event")
public class EventController {
    /**
     * 服务对象
     */
    @Resource
    private EventService eventService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("add")
    @Transactional
    @LcnTransaction
    public void selectOne(String id) {
        Event event = new Event();
        event.setType("1");
        restTemplate.postForEntity("http://lcn-pay:8090/event/add","",String.class);
        int a=1/0;
         this.eventService.insert(event);
    }

}