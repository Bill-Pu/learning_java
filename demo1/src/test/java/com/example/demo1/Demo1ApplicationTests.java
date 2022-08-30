package com.example.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
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
        System.out.println();
    }

}
