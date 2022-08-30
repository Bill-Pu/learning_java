package com.example.demo1.rabbitMq.demo1;

import com.example.demo1.rabbitMq.MqConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author ：Puyb
 * @date ：Created in 2021/12/29 16:42
 * @description：
 */
public class ProducerTest {
    public static void main(String[] args) {
        final Channel channel = MqConnectUtil.newConnectOfMq();
        String s = "";
        try {
            /**
             * 生成一个队列
             * 1.队列名称
             * 2.队列里面的消息是否持久化 默认消息存储在内存中
             * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
             * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
             * 5.其他参数
             */
            channel.queueDeclare("hello", false, false, false, null);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                System.out.printf("发送消息 %s", s);
                /**
                 * 发送一个消息
                 * 1.发送到那个交换机
                 * 2.路由的 key 是哪个
                 * 3.其他的参数信息
                 * 4.发送消息的消息体
                 */
                channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, s.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

