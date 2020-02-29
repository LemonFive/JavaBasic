import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @desc:
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
            producer.setNamesrvAddr("192.168.81.5:9876");

            // 启动一个Producer
            producer.start();

        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
        //插入五条数据
        for (int i = 0; i < 5; i++) {
            send("TopicTest", "测试生产数据" + i);
        }
    }

    public static void send(String topic, String message) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        // 构建一条消息对象
        // 参数含义：
        // topic 指定发送到哪个Topic上去
        // tag   消息的tag
        // body  消息的内容
        Message msg = new Message(topic, "", message.getBytes(RemotingHelper.DEFAULT_CHARSET));

        // 利用Producer发送消息
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);
    }
}
