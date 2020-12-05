package com.pay.order.dao;

import com.pay.order.entry.Event;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventDao {
    Event findById(String id);

    void updateType(String id);
}
