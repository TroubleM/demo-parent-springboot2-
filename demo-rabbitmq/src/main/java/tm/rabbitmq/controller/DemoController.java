package tm.rabbitmq.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.rabbitmq.constant.RabbitMqConstants;
import tm.rabbitmq.model.DemoModel;

/**
 * @auther: zhangyi
 * @date: 2019/7/11
 * @Description: demo-rabbitMq 控制层
 */
@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @Author zhangyi
     * @Description: 发送消息至第一个Demo队列
     * @Date  2019/7/11
     * @Param [demoModel]
     * @return java.lang.Object
     **/
    @GetMapping(value = "sendMessageToQueueOne")
    public Object sendMessageToQueueOne(DemoModel demoModel){
        try {
            Message message = MessageBuilder.withBody(JSONObject.toJSONString(demoModel).getBytes()).build();
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            rabbitTemplate.convertAndSend(RabbitMqConstants.DEMO_EXCHANGE
                    , RabbitMqConstants.DEMO_QUEUE_ONE_ROUTING_KEY
                    , message, new CorrelationData("我看你有戏"));
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }



}
