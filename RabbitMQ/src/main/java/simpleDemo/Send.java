package simpleDemo;


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

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtil.getConnetion();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String msg="hello simple";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("发送msg信息:"+msg);
        channel.close();
        connection.close();
    }
}
