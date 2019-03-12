package com.zhw.kafkademo.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhw.kafkademo.service.KafkaService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	KafkaService kafkaServer;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public String kafkaProductController() throws InterruptedException {
		
		for (int i = 0;i < 10; i++) {
			Thread.sleep(500);
			kafkaTemplate.send("test-topic-1", "test..." + i);
		}
		return "success";
	}
	
	/*@RequestMapping(value = "/consumer", method = RequestMethod.GET)
	public String kafkaConsumerController(Long num) {
		kafkaServer.getMessage(msg);
		return "";
	}*/
	
}
