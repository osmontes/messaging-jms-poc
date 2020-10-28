package com.paradigmadigital.poc.jms;

import com.paradigmadigital.poc.jms.dto.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJms
@Slf4j
public class Application {

	private static String messageString;
	private static String messageMap;
	private static String messagePojo;

	@Value("${destination.message.string}")
	private void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	@Value("${destination.message.map}")
	private void setMessageMap(String messageMap) {
		this.messageMap = messageMap;
	}

	@Value("${destination.message.pojo}")
	private void setMessageJson(String messagePojo) {
		this.messagePojo = messagePojo;
	}



	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		log.info("Enviando mensajes");

		jmsTemplate.convertAndSend(messageString, "Hola, estoy es un string");
		Map<String, String> map = new HashMap();
		map.put("texto", "Hola, esto es un mapa");
		jmsTemplate.convertAndSend(messageMap, map);
		jmsTemplate.convertAndSend(messagePojo, new Email("info@example.com", "Hello"));
	}

}
