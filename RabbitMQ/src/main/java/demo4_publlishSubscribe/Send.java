package demo4_publlishSubscribe;


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

    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtil.getConnetion();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //发送消息
        String msg = "hello ps";

        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());

        System.out.println("Send:"+msg);

        channel.close();
        connection.close();
    }
}
