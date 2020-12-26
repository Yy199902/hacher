package com.lock.redlock;

import com.lock.redlock.annotation.RedLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class Test {

    int count = 50;

    @GetMapping("/tset")
    @RedLock(redisKey = "name")
    public void test() {
        if (count > 0) {
            count--;
            System.out.println(count);
        }

    }
}
