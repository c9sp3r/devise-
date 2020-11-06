package com.isi.devise_crud.service;

import com.isi.devise_crud.model.Devise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuisnessService {

    @Autowired
    private com.isi.devise_crud.service.Service service;


    //to
    public double convertToTND(String devise, double price) throws Exception {
             Devise dev=service.get_devise(devise);
        if(dev!=null){
                double result= price/dev.getDevise_price();
                return result;
        }
                return 0;
    }


}
