package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：Puyb
 * @date ：Created in 2022/7/29 16:53
 * @description：
 */
public class ThreadPoolAndExtendCallnable {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        final Mycallnable mycallnable = new Mycallnable();
        List<Future<String>> add = new ArrayList<>();
        for (int i =0;i<10;i++){
            Future<String> submit = executor.submit(mycallnable);
            add.add(submit);
        }
        add.forEach(P->{
            String s = null;
            try {
                s = P.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(s);
        });
    }
}
