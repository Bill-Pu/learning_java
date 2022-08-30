package com.example.demo1.rabbitMq.demo1;

import com.example.demo1.rabbitMq.MqConnectUtil;
import com.rabbitmq.client.AMQP;
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
    public static void main(String[] args) throws IOException {
        final String QUEUE_NAME = "hello";

        final Channel channel = MqConnectUtil.newConnectOfMq();


        System.out.println("等待接收消息....");
        //推送的消息如何进行消费的接口回调
        //判断队列消息数量
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(QUEUE_NAME);
        Integer queueCount = declareOk.getMessageCount();
        while (queueCount != 0) {

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody());
                System.out.println(message);
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
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

        }
    }
}
