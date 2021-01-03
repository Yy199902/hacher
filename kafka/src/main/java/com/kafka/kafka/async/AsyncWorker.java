package com.kafka.kafka.async;

import java.util.concurrent.*;

/**
 * @author 86158
 */
public class AsyncWorker {

    private AsyncWorker(){

    }
    //当线程空闲30s开启回收
    private static final int KEEP_ALIVE_TIME = 30;
    private static final ThreadPoolExecutor THREAD_POOL =new ThreadPoolExecutor(5, Integer.MAX_VALUE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(), new DefaultThreadFactory("测试"));
    public static void execute(final Runnable runnable) {
        THREAD_POOL.execute(runnable);
    }

    public static void shutdown() {
        THREAD_POOL.shutdown();
    }
}
