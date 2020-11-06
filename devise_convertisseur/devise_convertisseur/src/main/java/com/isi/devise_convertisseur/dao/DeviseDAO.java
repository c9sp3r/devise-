package com.isi.devise_convertisseur.dao;

import com.isi.devise_convertisseur.model.Devise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeviseDAO extends MongoRepository<Devise, String> {
public Devise findByDeviseName(String deviseName);
public List<Devise> findAll();


}