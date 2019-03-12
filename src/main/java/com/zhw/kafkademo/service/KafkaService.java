package com.zhw.kafkademo.service;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaService {

	void getMessage(String msg);

	void getMessage(ConsumerRecord<String, String> record);

}
