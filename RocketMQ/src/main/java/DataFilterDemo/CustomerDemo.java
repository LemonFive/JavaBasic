package DataFilterDemo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
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
                    // 消费者分组:customer_group2
                    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("customer_group");

                    // 配置消费者信息
                    // 这样才能知道每个Topic的数据分散在哪些Broker机器上
                    // 然后才可以从对应的Broker上去拉取数据
                    consumer.setNamesrvAddr("192.168.222.5:9876");

                    // 选择订阅TopicTest，并根据tag进行过滤
//                    consumer.subscribe("DataFilterDemo", "TableA || TableB");

                    // 根据属性进行过滤，需要在broker.conf进行配置enablePropertyFilter=true方能使用属性过滤
                    consumer.subscribe("DataFilterDemo", MessageSelector.bySql("a>=50"));

                    //注册消息监听器，拉取订单消息回调
                    consumer.registerMessageListener(new MessageListenerConcurrently() {
                        @Override
                        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                            for (MessageExt msg : list) {
                                System.out.println(new String(msg.getBody()));
                            }
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
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
