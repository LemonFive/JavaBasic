package demo4_publlishSubscribe;

/**
 * @desc: 订阅模式
 * 交换机没有存储的能力，在RabbitMQ中只有队列有存储的能力
 * 当没有队列绑定到交换机时，消息丢失
 *
 * 交换机一方面接受生产者的消息，另一方面，向队列推送消息
 *
 * 匿名转发：
 *
 * Fanout(不处理路由键)
 * Direct（处理路由键）
 * @author: CuiShiHao
 **/
public class publlishSubscribeDemo {
}
