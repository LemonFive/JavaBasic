package OrderlyDemo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @desc: 消息顺序机制
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
        // 假设当前订单ID为1000
        final Integer orderId = 1000;
        //顺序插入五条数据
        for (int i = 0; i < 5; i++) {
            Message msg = new Message("OrderlyDemo", "", ("测试顺序数据" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(
                    msg,
                    new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                            long index = orderId % list.size();       // 对当前订单取模 选择发送的queue
                            return list.get((int) index);
                        }
                    }, orderId);
            System.out.printf("%s%n", sendResult);
        }
    }
}
