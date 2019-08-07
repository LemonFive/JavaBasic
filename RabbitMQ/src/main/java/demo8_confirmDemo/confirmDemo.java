package demo8_confirmDemo;

/**
 * @desc: confirmDemo
 * 生产者将信道设置成confirm
 * 所有在信道中的消息设成confirm模式，所有在该信道的消息指派一个ID，投到可匹配的队列后，回执一条消息给生产者。
 *
 * 优点：异步的
 *
 * 模式
 * 普通 发一条 waitForConfirms
 * 批量 发一批 waitForConfirms
 * 异步confirm模式：提供一个回调方法
 *
 * @author: CuiShiHao
 **/
public class confirmDemo {
}
