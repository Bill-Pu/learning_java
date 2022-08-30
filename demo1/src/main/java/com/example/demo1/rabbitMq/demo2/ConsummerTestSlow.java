package com.example.demo1.rabbitMq.demo2;

import com.example.demo1.rabbitMq.MqConnectUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @author ：Puyb
 * @date ：Created in 2021/12/29 17:18
 * @description：
 */
public class ConsummerTestSlow {
    public static final String TASK = "task";

    public static void main(String[] args) throws IOException {
        final Channel channel = MqConnectUtil.newConnectOfMq();
        System.out.println("sleep10s");
        final AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(TASK);
        DeliverCallback deliverCallback = (consumer, msg) -> {
            String s = new String((msg.getBody()));
            System.out.println("收到消息" + s);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            channel.basicAck(msg.getEnvelope().getDeliveryTag(), false);
        };
        channel.basicConsume(TASK, false, deliverCallback, cancelCallback -> {
            System.out.println("中断");
        });
    }
}
