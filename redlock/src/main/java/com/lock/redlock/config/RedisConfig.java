package com.lock.redlock.config;

import com.lock.redlock.lock.RedisRedLock;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisConfig {



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
}
