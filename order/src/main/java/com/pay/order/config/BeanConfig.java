package com.pay.order.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class BeanConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("ActiveMQQueue");
    }
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
       return new ActiveMQConnectionFactory("admin","admin",brokerUrl);
    }
}
