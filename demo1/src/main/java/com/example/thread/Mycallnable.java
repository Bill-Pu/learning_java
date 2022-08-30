package com.example.thread;

import java.util.concurrent.Callable;

/**
 * @author ：Puyb
 * @date ：Created in 2022/7/25 16:12
 * @description：
 */
public class Mycallnable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        Thread.sleep(5000);
        return Thread.currentThread().getName();
    }
}
