package com.pay.pay.dao;

import com.pay.pay.entry.Event;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
    void add(Event event);
}
