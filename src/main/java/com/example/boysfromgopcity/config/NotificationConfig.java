package com.example.boysfromgopcity.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

//    spring.rabbitmq.template.exchange=internal.exchange
//    spring.rabbitmq.template.default-receive-queue=notification.queue
//    spring.rabbitmq.template.routing-key=internal.notification.routing-key

//    @Value("${rabbitmq.exchanges.internal}")
//    private String internalExchange;
//
//    @Value("${rabbitmq.queue.notification}")
//    private String notificationQueue;
//
//    @Value("${rabbitmq.routing-keys.internal-notification}")
//    private String internalNotificationRoutingKey;

    private final String internalExchange = "internal.exchange";

    private final String notificationQueue = "notification.queue";

    private final String internalNotificationRoutingKey = "internal.notification.routing-key";

    @Bean
    public TopicExchange internalTopicExchange(){
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue notificationQueue(){
        return new Queue(this.notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding(){
        return BindingBuilder.
                bind(notificationQueue()).
                to(internalTopicExchange()).
                with(this.internalNotificationRoutingKey);
    }

    public String getInternalExchange() {
        return internalExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}
