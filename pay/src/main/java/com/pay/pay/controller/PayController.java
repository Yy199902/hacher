package com.pay.pay.controller;

import com.pay.pay.dao.PayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private PayDao payDao;

    @GetMapping("test")
    @Transactional
    public String test(){
        payDao.updateByType(1);
      test1();
        return "1";
    }

    public void test1(){
        payDao.updateTr(1);
        System.out.println(1/0);
    }

}
