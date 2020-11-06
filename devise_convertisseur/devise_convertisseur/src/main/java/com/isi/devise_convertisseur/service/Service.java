package com.isi.devise_convertisseur.service;

import java.util.List;
import java.util.Objects;

import com.isi.devise_convertisseur.dao.DeviseDAO;
import com.isi.devise_convertisseur.model.Devise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired 
	private DeviseDAO mongo;

	public void create_devise(String name, double devise)throws Exception {
		mongo.save(new Devise (name,devise));
	}

	public Devise get_devise(String name)throws Exception {
		return (mongo.findByDeviseName(name));
	}

	public void remove_devise(String name)throws Exception {
		Devise s = mongo.findByDeviseName(name);
		if(s !=null){
            mongo.deleteById(s.getId());
	}
	}

	public void update_devise(String name, double devise)throws Exception {
		Devise s = mongo.findByDeviseName(name);
		if(s !=null){
			mongo.save(new Devise (name,devise));

		}
	}


public List<Devise> findAll(){
	return(mongo.findAll());
}




}