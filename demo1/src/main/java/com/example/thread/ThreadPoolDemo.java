package com.example.thread;

import lombok.val;
import lombok.var;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ：Puyb
 * @date ：Created in 2022/7/25 16:30
 * @description：
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         ExecutorService executorService = Executors.newCachedThreadPool();
         Future<String> submit = executorService.submit(new Mycallnable());
        System.out.println(submit.get());
        submit.cancel(false);
    }
}
