package com.example.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//@SpringBootTest
class Demo1ApplicationTests {

    @Test
    void contextLoads() throws ExecutionException, InterruptedException {
        final ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(1, "1");
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();
        new ConcurrentSkipListMap<>();
        final CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
//        Collections.synchronizedList(list);
        final LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        final CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
        final CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(111);
            return 111;
        });
        final Integer integer = integerCompletableFuture.get();
        System.out.println("devTest");
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        final int[] i = {0};
        ReentrantLock lock = new ReentrantLock();
        for (int j = 0; j < 1000; j++) {
            executorService.submit(() -> {
                try {
                    lock.lock();
                    i[0] = i[0] + 1;
                } finally {
                    lock.unlock();
                }
            });
        }
        for (int j = 0; j < 1000; j++) {
            executorService.submit(() -> {
                try {
                    lock.lock();
                    i[0] = i[0] - 1;
                } finally {
                    lock.unlock();
                }
            });
        }

    }
    @Test
    void concurrentTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        final int[] i = {0};
        CountDownLatch countDownLatch = new CountDownLatch(2000);
        ReentrantLock lock = new ReentrantLock();
        for (int j = 0; j < 1000; j++) {
            executorService.submit(() -> {
                countDownLatch.countDown();
                try {
//                    lock.lock();
                    i[0] = i[0] + 1;
                } finally {
                    lock.unlock();
                }
            });
        }
        for (int j = 0; j < 1000; j++) {
            executorService.submit(() -> {
                countDownLatch.countDown();

                try {
//                    lock.lock();
                    i[0] = i[0] - 1;
                } finally {
                    lock.unlock();
                }
            });
        }
        System.out.println(System.currentTimeMillis());
        System.out.println("开始等待");
        try {
            countDownLatch.wait();

        }
        System.out.println(System.currentTimeMillis());

        System.out.println("输出结果");
        System.out.println(i);
    }
}
