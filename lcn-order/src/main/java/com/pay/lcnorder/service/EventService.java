package com.pay.lcnorder.service;

import com.pay.lcnorder.entity.Event;

import java.util.List;

/**
 * (Event)表服务接口
 *
 * @author makejava
 * @since 2020-12-06 19:01:35
 */
public interface EventService {

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    void insert(Event event);


}