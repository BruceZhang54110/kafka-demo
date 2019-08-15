package com.zhw.kafkademo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${demo.topic}")
	private String topic;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public String kafkaProductController() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			kafkaTemplate.send(topic, "mess " + i);
		}
		return "success";
	}
	
	/*@RequestMapping(value = "/consumer", method = RequestMethod.GET)
	public String kafkaConsumerController(Long num) {
		kafkaServer.getMessage(msg);
		return "";
	}*/
	
}
