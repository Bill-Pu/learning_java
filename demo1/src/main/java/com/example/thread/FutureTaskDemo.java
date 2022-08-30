package com.example.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：Puyb
 * @date ：Created in 2022/7/25 16:19
 * @description：
 */
public class FutureTaskDemo {
    public static void main(String[] args) {

        final FutureTask<String> stringFutureTask = new FutureTask<>(new Mycallnable());
        final Thread thread = new Thread(stringFutureTask);
        thread.start();
        try {
            //监控执行结果
            final String s = stringFutureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
