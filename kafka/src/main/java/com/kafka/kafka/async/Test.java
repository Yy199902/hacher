package com.kafka.kafka.async;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * description: Test <br>
 * date: 2021/1/3 14:44 <br>
 * author: yuyin <br>
 * version: 1.0 <br>
 */
public class Test {
    static ThreadLocal<SimpleDateFormat>threadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static void main(String[] args) {
        AsyncWorker.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(threadLocal.get().parse("2019-10-22 16:59:00"));
                    throw new NullPointerException("sfa");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
