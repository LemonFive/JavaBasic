package workfairDemo;


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

    private static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取连接
        Connection connection = ConnectionUtil.getConnetion();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        // 每个消费者发送确认消息之前，消息队列不发送下一个消费到消费者，一次只处理一个消息
        // 限制发送给同一个消费者不得超过一条
        int prefectchCount = 1;
        channel.basicQos(prefectchCount);

        for(int i= 0;i<50;i++) {
            String msg = "hello simple "+i;

            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

            System.out.println("发送msg信息:" + msg);

            Thread.sleep(i*20);
        }
        channel.close();
        connection.close();
    }
}
