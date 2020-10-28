package com.paradigmadigital.poc.jms;

import com.paradigmadigital.poc.jms.dto.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class Receiver {

    @JmsListener(destination = "${destination.message.string}", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessageString(String string) {
        log.info("Recibiendo string <" + string + ">");
    }

    @JmsListener(destination = "${destination.message.map}", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessageMap(Map map) {
        log.info("Recibiendo map<" + map + ">");
    }

    @JmsListener(destination = "${destination.message.pojo}", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessageString(Email email) {
        log.info("Recibiendo pojo<" + email + ">");
    }

}
