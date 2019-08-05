package workqueueDemo;

/**
 * @desc:  RabbitMQ 工作队列模式——Round robin轮询分发
 * Simple队列是异议对应的，而我们实际开发中，生产者发送消息是毫不费力的，而消费者消费一般需要和业务相结合，需要消耗时间处理。
 * 当队列积压了很多消息时，多个消费者同时处理消息。
 *
 * 消费者1和消费者2处理的消息是一样的，均分的。RabbitMQ并不知道消费者的能力！！
 * 这种方式叫做轮询分发（round-robin）
 * 不管谁忙或者谁清闲都不会多发信息，你一个我一个。
 *
 *  boolean autoAck = true (自动确认模式)
 *  一旦rabbitmq将消息分发给消费者，就会从内存中删除
 *  这种情况下，如果杀死正在执行的消费者，就会丢失正在处理的消息
 *
 * @author: CuiShiHao
 **/
public class workqueueDemo {
}
