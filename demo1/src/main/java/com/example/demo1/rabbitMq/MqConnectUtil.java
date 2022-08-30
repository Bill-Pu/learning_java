package com.example.demo1.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：Puyb
 * @date ：Created in 2021/12/20 17:45
 * @description：
 */
public class MqConnectUtil {
    public static Channel newConnectOfMq() {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.31.239.128");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Channel channel = null;
        Connection connection = null;
        try {
            //创建连接
            connection = connectionFactory.newConnection();
            //创建信道
            channel = connection.createChannel();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }

}
