package com.isi.devise_convertisseur.controller;

import java.util.List;
import java.util.Optional;

import com.isi.devise_convertisseur.events.CreateEvent;
import com.isi.devise_convertisseur.events.DeleteEvent;
import com.isi.devise_convertisseur.events.Event;
import com.isi.devise_convertisseur.events.UpdateEvent;
import com.isi.devise_convertisseur.model.Devise;
import com.isi.devise_convertisseur.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
	KafkaTemplate<String, Event> kafkaTemplate;

	
	@Autowired
	Service service;

	@PostMapping("/create/{name}/{price}")
	public void  create(@PathVariable String name, @PathVariable double price) {
		try {
			service.create_devise(name,price);
			kafkaTemplate.send("devise",new CreateEvent(new Devise(name,price)));
			System.out.println("devise has been saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/read")
	public List<Devise> read(){
		return service.findAll();
	}
	
	@GetMapping("/read/{name}")
	public Devise read(@PathVariable String name) throws Exception {
		Devise de = service.get_devise(name);
		if(de!=null)
			return de;
		else
			 return null;

	}
	
	@PutMapping("/update")
	@Transactional
	public void update(@RequestBody String name, @RequestBody double price) throws Exception {
		service.update_devise(name,price);
		kafkaTemplate.send("devise",new UpdateEvent(new Devise(name,price)));
      System.out.println(name+" has been successfully updated");
	}
	
	@DeleteMapping("/delete/{name}")
	@Transactional
	public String delete(@PathVariable String name) throws Exception {
		Devise de = service.get_devise(name);
		if(de!=null) {

              service.remove_devise(name);
			kafkaTemplate.send("devise",new DeleteEvent(name));
              			return " deleted with name "+name;
		}else {
			throw new RuntimeException("devise not found for name "+name);
		}
	}










	
}