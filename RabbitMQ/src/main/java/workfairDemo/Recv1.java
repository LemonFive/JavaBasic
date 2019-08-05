package workfairDemo;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class Recv1 {

    private static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnetion();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //保证一次只分发一个
        channel.basicQos(1);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // 捕获消息内容
                String message = new String(body, "UTF-8");
                System.out.println("Recv1获取队列结果："+message);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };

        boolean autoAck = false;
        //监听队列 第二个参数值为false代表关闭RabbitMQ的自动应答机制，改为手动应答。
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }
}
