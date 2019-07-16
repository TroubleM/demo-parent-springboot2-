package tm.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tm.rabbitmq.constant.RabbitMqConstants;

/**
 * @auther: zhangyi
 * @date: 2019/7/11
 * @Description: 消息接收者
 */
@Component
public class DemoReceiver {

    /**
     * @Author zhangyi
     * @Description: 自动创建队列，Exchange 与 Queue绑定
     * @Date  2019/7/11
     * @Param [message]
     * @return void
     **/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMqConstants.DEMO_QUEUE_ONE, durable = "true"),
            exchange = @Exchange(value = RabbitMqConstants.DEMO_EXCHANGE, durable = "true", autoDelete = "false"),
            key = RabbitMqConstants.DEMO_QUEUE_ONE_ROUTING_KEY
    ),containerFactory = "simpleRabbitListenerContainerFactory")
    public void process3(Message message, Channel channel) throws Exception {
        System.out.println(message);
        System.out.println(new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}