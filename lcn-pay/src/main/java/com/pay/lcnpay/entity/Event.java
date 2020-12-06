package com.pay.lcnpay.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Event)实体类
 *
 * @author makejava
 * @since 2020-12-06 19:01:34
 */
@Data
public class Event implements Serializable {
    private static final long serialVersionUID = 283856427711610735L;
    /**
     * 主键
     */
    private Long id;

    private String type;


}