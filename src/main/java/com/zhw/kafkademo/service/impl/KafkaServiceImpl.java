package com.zhw.kafkademo.service.impl;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.zhw.kafkademo.service.KafkaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaServiceImpl implements KafkaService {

	@KafkaListener(topics="${dlink.kafka.topic.sdata}", groupId="${spring.kafka.consumer.group-id}")
	//@Override
	public void getMessage1(ConsumerRecord<String, String> record) {
		log.info("从dlink.kafka.topic.sdata消费到 " + record.value() + ", " + Thread.currentThread().getId()+", " + record.key() );
	}

	@KafkaListener(topics="${dlink.kafka.topic.tr.pull}", groupId="${spring.kafka.consumer.group-id}")
	@Override
	public void getMessage(ConsumerRecord<String, String> record) {
		log.info("从dlink.kafka.topic.tr.pull消费到 " + record.value() + ", " + Thread.currentThread().getId()+", " + record.key() );
	}
	
	@KafkaListener(topics="${dlink.kafka.topic.tr.state}", groupId="${spring.kafka.consumer.group-id}")
	//@Override
	public void getMessage11(ConsumerRecord<String, String> record) {
		log.info("从dlink.kafka.topic.tr.state消费到 " + record.value() + ", " + Thread.currentThread().getId()+", " + record.key() );
	}

	@Override
	public void getMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

}
