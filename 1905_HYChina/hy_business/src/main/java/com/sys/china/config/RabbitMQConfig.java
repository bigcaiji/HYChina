package com.sys.china.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    public Binding binding(Queue queue,TopicExchange topicExchange){
        //把queue绑定到交换机上
        return BindingBuilder.bind(queue).to(topicExchange).with(QUEUE_NAME);
    }

}
