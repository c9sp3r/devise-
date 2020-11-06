package com.isi.devise_crud.events;


import com.isi.devise_crud.model.Devise;
import com.isi.devise_crud.model.EventType;

public class UpdateEvent extends Event {

    private Devise devise;

    public Devise getDevise() {
        return devise;
    }

    public UpdateEvent(){
        super(EventType.UPDATE);


    }


    public UpdateEvent(Devise devise){
        super(EventType.UPDATE);
        this.devise=devise;

    }



}
