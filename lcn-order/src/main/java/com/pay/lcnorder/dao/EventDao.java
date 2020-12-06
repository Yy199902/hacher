package com.pay.lcnorder.dao;

import com.pay.lcnorder.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Event)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-06 19:01:34
 */
@Mapper
public interface EventDao {

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 影响行数
     */
    int insert(Event event);



}