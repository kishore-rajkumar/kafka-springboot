package com.kishore.kafkaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import kafka.producer.MessageProducer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		MessageProducer producer = context.getBean(MessageProducer.class);
		producer.sendMessage("Hello THere! This message is sent programatically.");

	}

}
