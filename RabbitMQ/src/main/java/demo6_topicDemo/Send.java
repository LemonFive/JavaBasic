package demo6_topicDemo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @desc: 创建一个生产者
 * @author: CuiShiHao
 **/
public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtil.getConnetion();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");

        String msg = "商品...";

        channel.basicPublish(EXCHANGE_NAME,"goods.delete",null,msg.getBytes());

        System.out.println("-------send" + msg);

        channel.close();
        connection.close();
    }
}
