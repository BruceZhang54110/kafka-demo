package com.zhw.kafkademo.service.impl;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.zhw.kafkademo.service.KafkaService;

@Component
public class KafkaServiceImpl implements KafkaService {

	@KafkaListener(topics="test-topic-1")
	//@Override
	public void getMessage1(ConsumerRecord<String, String> record) {
		System.out.println("getMessage-1消费到 " + record.value() + ", " + Thread.currentThread().getId()+", " + record.key() );
	}

	@KafkaListener(topics="test-topic-1")
	@Override
	public void getMessage(ConsumerRecord<String, String> record) {
		System.out.println("getMessage-2消费到 " + record.value() + ", " + Thread.currentThread().getId() +", " + record.key() );
		
	}

	@Override
	public void getMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

}
