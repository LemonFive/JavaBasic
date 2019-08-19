package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @desc:  RabbitMQ 配置连接地址
 * @author: CuiShiHao
 **/
public class ConnectionUtil {

    public static Connection getConnetion() throws IOException, TimeoutException {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务相关地址参数
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/vhost_test");
        factory.setUsername("user");
        factory.setPassword("user");

        return factory.newConnection();
    }
}
