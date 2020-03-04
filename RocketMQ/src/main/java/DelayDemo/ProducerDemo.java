package DelayDemo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @desc: 延迟机制demo
 * @author: CuiShiHao
 **/
public class ProducerDemo {

    // RocketMQ的生产者类，用这个就可以发送消息到RocketMQ
    private static DefaultMQProducer producer;

    static {
        try {
            // 这里就是构建一个Producer实例对象
            producer = new DefaultMQProducer("order_producer_group");

            // 为Producer设置NameServer的地址，拉取路由信息
            // 这样才能知道每个Topic的数据分散在哪些Broker机器上
            // 然后才可以把消息发送到Broker上去
            producer.setNamesrvAddr("192.168.222.5:9876");

            // 启动一个Producer
            producer.start();

        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
        // 构建一条消息对象
        // 参数含义：
        // topic 指定发送到哪个Topic上去
        // tag   消息的tag
        // body  消息的内容
        Message msg1 = new Message("DelayDemo", "", "数据记录1".getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 设置延迟级别
        msg1.setDelayTimeLevel(4);
        // 利用Producer发送消息
        SendResult sendResult1 = producer.send(msg1);
        System.out.printf("%s%n", sendResult1);


        Message msg2 = new Message("DelayDemo", "", "数据记录2".getBytes(RemotingHelper.DEFAULT_CHARSET));
        msg1.setDelayTimeLevel(3);
        SendResult sendResult2 = producer.send(msg2);
        System.out.printf("%s%n", sendResult2);

        Message msg3 = new Message("DelayDemo", "", "数据记录3".getBytes(RemotingHelper.DEFAULT_CHARSET));
        msg1.setDelayTimeLevel(3);
        SendResult sendResult3 = producer.send(msg3);
        System.out.printf("%s%n", sendResult3);
    }
}
