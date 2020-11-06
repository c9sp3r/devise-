package com.isi.devise_crud.controller;

import java.util.List;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.isi.devise_crud.events.CreateEvent;
import com.isi.devise_crud.events.DeleteEvent;
import com.isi.devise_crud.events.Event;
import com.isi.devise_crud.events.UpdateEvent;
import com.isi.devise_crud.model.Devise;

import com.isi.devise_crud.model.EventType;
import com.isi.devise_crud.service.BuisnessService;
import com.isi.devise_crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class DeviseController {
    @Autowired
	BuisnessService bservice;


	@Autowired
	Service service;



	
	@GetMapping("/convert/{devise}/{price}")
	public double convert(@PathVariable String devise,@PathVariable double price )  {

		try {
			return  bservice.convertToTND(devise,price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
	@KafkaListener(topics = "devise", groupId = "group_id")
	public void synchronize(@Payload String message) throws Exception {
		ObjectMapper objectMapper=new ObjectMapper();
		final ObjectNode node = new ObjectMapper().readValue(message, ObjectNode.class);

		EventType eventType=EventType.valueOf(node.get("type").asText());
		System.out.println(eventType);
		switch( eventType ){
			case CREATE:
				CreateEvent event2= objectMapper.readValue(message ,CreateEvent.class);
				service.create_devise(event2.getDevise().getDevise_name(),event2.getDevise().getDevise_price());
				break;
			case UPDATE:
				UpdateEvent event3= objectMapper.readValue(message ,UpdateEvent.class);
				service.update_devise(event3.getDevise().getDevise_name(),event3.getDevise().getDevise_price());
				break;
			case DELETE:
				System.out.println("hello from delete");
				DeleteEvent event4= objectMapper.readValue(message ,DeleteEvent.class);
				System.out.println(event4.getName());
				service.remove_devise(event4.getName());
				break;

		}
	}
	

	
}