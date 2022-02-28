package com.kishore.kafkaspringboot;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class MessageConsumer {
	
	@Value(value = "${message.topic.name}")
    private String topicName;

	private CountDownLatch latch = new CountDownLatch(3);
	
	@KafkaListener(topics = "${message.topic.name}",groupId="foo",
			containerFactory = "fooKafkaListenerContainerFactory")
	public void listener1(String message) {
		System.out.println("Received message :" + message);
		latch.countDown();
	}

}
