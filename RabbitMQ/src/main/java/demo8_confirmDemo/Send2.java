package demo8_confirmDemo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @desc: 批量Send
 * @author: CuiShiHao
 **/
public class Send2 {

    private static final String QUEUE_NAME = "test_queue_confirm1";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取连接
        Connection connection = ConnectionUtil.getConnetion();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();
        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //生产者调用confirmSelect 将channel设置为confirm模式
        channel.confirmSelect();

        String msg="hello confirmMode";
        //批量发送
        for(int i=0;i<10;i++) {
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        }
        System.out.println("发送msg信息:"+msg);

        //确认
        if(!channel.waitForConfirms()){
            System.out.println("发送失败");
        }
        else{
            System.out.println("发送成功！");
        }

        channel.close();
        connection.close();
    }
}
