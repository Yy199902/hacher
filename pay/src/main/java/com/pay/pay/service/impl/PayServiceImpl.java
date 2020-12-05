package com.pay.pay.service.impl;

import com.pay.pay.dao.PayDao;
import com.pay.pay.entry.Event;
import com.pay.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayDao payDao;
    @Override
    public void add(Event event) {
        payDao.add(event);
    }
}
