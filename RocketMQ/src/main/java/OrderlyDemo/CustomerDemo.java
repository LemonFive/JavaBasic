package OrderlyDemo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @desc: 消费组
 * @author: CuiShiHao
 **/
public class CustomerDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    //创建RocketMQ消费者实例对象
                    // 消费者分组:customer_group1
                    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("customer_group");

                    // 配置消费者信息
                    // 这样才能知道每个Topic的数据分散在哪些Broker机器上
                    // 然后才可以从对应的Broker上去拉取数据
                    consumer.setNamesrvAddr("192.168.222.5:9876");

                    // 选择订阅TopicTest
                    consumer.subscribe("OrderlyDemo", "*");

                    //注册消息监听器，拉取订单消息回调（采用MessageListerOrderly顺序获取处理消息）
                    consumer.registerMessageListener(
                            new MessageListenerOrderly() {
                                @Override
                                public ConsumeOrderlyStatus consumeMessage(
                                        List<MessageExt> list,
                                        ConsumeOrderlyContext consumeOrderlyContext) {
                                    consumeOrderlyContext.setAutoCommit(true);
                                    try {
                                        for (MessageExt msg : list) {
                                            // 对有序的消息进行处理
                                            System.out.println(new String(msg.getBody()));
                                        }
                                        return ConsumeOrderlyStatus.SUCCESS;
                                    } catch (Exception e) {
                                        // 如果消息处理有问题
                                        // 返回一个状态，让他暂停一会儿再继续处理这批消息
                                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                                    }
                                }
                            });

                    //启动消费者实例
                    consumer.start();
                    System.out.println("Consumer Started");

                    // 不能让线程退出，consumer才能不停的消费数据
                    while (true) {
                        Thread.sleep(1000);
                    }
                } catch (MQClientException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
