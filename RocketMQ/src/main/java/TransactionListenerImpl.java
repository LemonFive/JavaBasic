import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @desc: TransactionListener实现类
 * @author: CuiShiHao
 **/
public class TransactionListenerImpl implements TransactionListener {

    // 如果half消息发送成功了
    // 就会回调这个函数，就可以执行本地事务了。
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        // 执行订单本地事务
        // 接着根据本地一连串事务执行结果，去选择执行commit or rollback
        try {
            // 本地事务执行成功，返回commit
            return LocalTransactionState.COMMIT_MESSAGE;
        } catch (Exception e) {
            // 本地事务执行失败，回滚所有执行过的操作
            // 本地事务执行失败，返回rollback，标记half消息无效
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
    }


    // 如果因为各种原因，RocketMQ没有收到commit或者rollback信息，RocketMQ回调接口。
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        // 查询本地事务，是否执行成功示例。
        Integer status = 1;
        if (null != status) {
            switch (status) {
                case 0:
                    return LocalTransactionState.UNKNOW;
                case 1:
                    return LocalTransactionState.COMMIT_MESSAGE;
                case 2:
                    return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        }
        return null;
    }
}
