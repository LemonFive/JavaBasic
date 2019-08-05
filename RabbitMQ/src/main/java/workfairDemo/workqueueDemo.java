package workfairDemo;

/**
 * @desc:  RabbitMQ工作队列
 * Simple队列是异议对应的，而我们实际开发中，生产者发送消息是毫不费力的，而消费者消费一般需要和业务相结合，需要消耗时间处理。
 * 当队列积压了很多消息时，多个消费者同时处理消息。
 *
 * 这种方式叫做公平分发（fair-dipatch）
 * 能者多劳，公平分发
 * @author: CuiShiHao
 *
 *  boolean autoAck = false (手动确认模式)
 *  如果有一个消费者挂掉，就会交付给其他消费者，rabbitmq支持消息应答，
 *  消费者发送一个消息应答，高数rabbitmq这个消息我已经处理完成了，你可以删了，然后RabbitMQ删除内存中的消息
 *
 *  此时加入RabbitMQ服务挂掉，我们的消息仍然会丢失
 *
 *
 *
 *  数据的持久化
 *
 *  boolean durable = true
 *  //创建队列声明
 *  channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
 *
 *  PS：同一个队列，RabbitMQ不允许重新定义（不同参数）一个已存在的队列。
 *
 **/
public class workqueueDemo {
}
