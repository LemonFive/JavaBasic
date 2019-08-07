package demo8_confirmDemo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * @desc: 异步confirm
 * @author: CuiShiHao
 **/
public class Send3 {

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

        //未确认的消息标识
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

        //通道添加监听
        channel.addConfirmListener(new ConfirmListener() {
            //没问题的handeleAck
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    System.out.println("----handleAck----multiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }
                else{
                    System.out.println("----handleAck----multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    System.out.println("----handleNack----multiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }
                else{
                    System.out.println("----handleNack----multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });

        String msg="hello confirmMode";
        //批量发送
        while(true) {
            long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            confirmSet.add(seqNo);
        }

//        channel.close();
//        connection.close();
    }
}
