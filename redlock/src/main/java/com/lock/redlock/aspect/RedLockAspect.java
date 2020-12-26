package com.lock.redlock.aspect;

import com.lock.redlock.annotation.RedLock;
import com.lock.redlock.lock.RedisRedLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class RedLockAspect {

    public static RLock create(String url, String key) {
        Config config = new Config();
        config.useSingleServer().setAddress(url);
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient.getLock(key);
    }
    private String redisKey;
    RedissonRedLock redissonRedLock = new RedissonRedLock(
            create("redis://192.168.223.148:6379", "lock_key1"),
            create("redis://192.168.223.148:6380", "lock_key2"),
            create("redis://192.168.223.148:6381", "lock_key3"));
    RedisRedLock redLock = new RedisRedLock(redissonRedLock);

    @Pointcut("@annotation(com.lock.redlock.annotation.RedLock)")
    public void operationLog() {
    }

    @Around("operationLog()&& @annotation(redisKey)")
    public Object doAround(ProceedingJoinPoint joinPoint,RedLock redisKey) {
        try {
            this.redisKey=redisKey.redisKey();
            redLock.lock();
            Object proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        } finally {
            redLock.unlock();
        }
        return null;
    }

}
