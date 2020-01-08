package com.syc.china.config;

import com.syc.china.rabbit.ReceiveMsg;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class RabbitMQConfig {

    public final static String QUEUE_NAME = "china_log_queue";

    public final static String TOPIC_NAME = "china_log_topic";

    /**
     * 创建队列
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    /**
     * 创建交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_NAME);
    }

    /**
     * 建立绑定关系-->队列与交换机进行绑定
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        //把queue绑定到交换机上
        return BindingBuilder.bind(queue).to(topicExchange).with(QUEUE_NAME);
    }

    /**
     * MessageListenerAdapter:负责接收消息
     */
    @Bean
    public MessageListenerAdapter messageListenerAdapter(ReceiveMsg receiver) {
        //利用ReceiveMsg对象里的receiveMsg()方法接收消息
        return new MessageListenerAdapter(receiver, "receiveMsg");
    }

    /**
     * 创建一个消息监听适配器运行所需要的容器类
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory factory,MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

}
