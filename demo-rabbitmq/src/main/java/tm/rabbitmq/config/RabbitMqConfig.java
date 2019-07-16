package tm.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tm.rabbitmq.constant.RabbitMqConstants;

import javax.annotation.PostConstruct;

/**
 * @auther: zhangyi
 * @date: 2019/4/20
 * @Description: rabiitMq配置类
 */
@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Autowired
    private ConfirmCallBackListener confirmCallBackListener;

    @Autowired
    private ReturnCallBackListener returnCallBackListener;

    /**
     * @Author zhangyi
     * @Description: 连接工厂
     * @Date  2019/4/23
     * @return org.springframework.amqp.rabbit.connection.ConnectionFactory
     **/
    @Bean("dempConnectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     * @Author zhangyi
     * @Description: RabbitTemplate手动实例化,
     * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
     * @Date  2019/4/23
     * @return org.springframework.amqp.rabbit.core.RabbitTemplate
     **/
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setConfirmCallback(confirmCallBackListener);
        rabbitTemplate.setReturnCallback(returnCallBackListener);
        rabbitTemplate.setMandatory(true);
        return rabbitTemplate;
    }

    /**
     * @Author zhangyi
     * @Description: 集装箱工厂定义
     * @Date  2019/4/23
     * @Param [connectionFactory]
     * @return org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
     **/
    @Bean("simpleRabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

}
