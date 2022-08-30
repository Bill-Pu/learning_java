package com.example.demo1.rabbitMq.demo2;

import com.example.demo1.rabbitMq.MqConnectUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @author ：Puyb
 * @date ：Created in 2021/12/29 16:40
 * @description：
 */
public class ConsummerTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String QUEUE_NAME = "task";

        final Channel channel = MqConnectUtil.newConnectOfMq();


        System.out.println("等待接收消息....");
        //推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("成功消费" + message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };
        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         * 4.消费者取消接受
         */
        //不公平分发
        channel.basicQos(1);
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, cancelCallback);
    }
}

