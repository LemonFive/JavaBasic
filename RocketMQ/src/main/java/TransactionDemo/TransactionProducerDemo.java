package TransactionDemo;

import TransactionDemo.TransactionListenerImpl;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * @desc: RocketMQ事物消息的代码实现
 * @author: CuiShiHao
 **/
public class TransactionProducerDemo {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException {
        // 接受RocketMQ回调的一个监听器接口，
        // 这里会实现执行本地事务，commit，rollback，回调查询等操作
        TransactionListener transactionListener = new TransactionListenerImpl();

        // 创建一个支持事务消息的Producer
        // 指定生产者分组为TestProducerGroup
        TransactionMQProducer producer = new TransactionMQProducer("TestProducerGroup");

        // 指定一个线程池
        // 用来处理RocketMQ回调你的请求
        ExecutorService exectorService = new ThreadPoolExecutor(
                2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("TestThread");
                        return thread;
                    }
                });

        // 给事务消息生产者设定对应的线程池，负责执行RocketMQ回调请求
        producer.setExecutorService(exectorService);
        // 给事务消息生产者设置对应的回调函数
        producer.setTransactionListener(transactionListener);
        // 为Producer设置NameServer的地址，拉取路由信息
        producer.setNamesrvAddr("192.168.222.5:9876");
        // 启动这个事务消息生产者
        producer.start();

        // 构造一条订单支付成功的消息，指定Topic是TransactionDemo
        Message msg = new Message("TransactionDemo", "TestTag", "TestKey", "测试事务消息".getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 利用Producer发送消息
        SendResult sendResult = producer.sendMessageInTransaction(msg, null);
        System.out.printf("%s%n", sendResult);
    }
}
