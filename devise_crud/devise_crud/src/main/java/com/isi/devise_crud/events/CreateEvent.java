package com.isi.devise_crud.events;


import com.isi.devise_crud.model.Devise;
import com.isi.devise_crud.model.EventType;

public class CreateEvent extends Event {
    public Devise getDevise() {
        return devise;
    }

    private Devise devise;

    public void setDevise(Devise devise) {
        this.devise = devise;
    }



    public CreateEvent(){
        super(EventType.CREATE);

    }

    public CreateEvent(Devise devise){
     super(EventType.CREATE);
     this.devise=devise;

 }


}