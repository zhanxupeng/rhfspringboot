package com.zhan.websys.common.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author zhanxp
 * @version 1.0 2018/10/30
 */
public class ThreadPoolHandler {
    private static ThreadFactory businessThreadFactory = new ThreadFactoryBuilder().setNameFormat("business-pool-%d").build();
    public static ExecutorService executorService = new ThreadPoolExecutor(5, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(1024), businessThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello World");
            System.out.println(Thread.currentThread());
        });

        executorService.execute(() -> {
            System.out.println("hello World1");
            System.out.println(Thread.currentThread());
        });
    }
}
