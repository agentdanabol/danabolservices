package com.danabol.customer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("fraud1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("fraud2");
    }

    @Bean
    public DirectExchange directExchange1(){
        return new DirectExchange("direct-exchange-1");
    }

    @Bean
    public TopicExchange topicExchange1(){
        return new TopicExchange("topic-exchange-1");
    }

    @Bean
    public Binding directBinding1(){
        return BindingBuilder.bind(myQueue1()).to(directExchange1()).with("fraud-new");
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(myQueue1()).to(topicExchange1()).with("*.fraud.*");
    }

//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer1() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setQueueNames("fraud_1");
//        //тут ловим сообщения из queue1
//        container.setMessageListener(message -> System.out.println(("received from queue1 : " + new String(message.getBody()))));
//        return container;
//    }

}
