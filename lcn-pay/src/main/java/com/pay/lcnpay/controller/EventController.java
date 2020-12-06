package com.pay.lcnpay.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.pay.lcnpay.entity.Event;
import com.pay.lcnpay.service.EventService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("add")
    @Transactional
    @LcnTransaction
    public void selectOne(String id) {
        System.out.println("进入");
        Event event = new Event();
        event.setType("1");
         this.eventService.insert(event);
    }

}