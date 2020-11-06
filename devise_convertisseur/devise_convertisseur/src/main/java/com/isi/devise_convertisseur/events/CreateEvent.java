package com.isi.devise_convertisseur.events;

import com.isi.devise_convertisseur.model.Devise;
import com.isi.devise_convertisseur.model.EventType;

public class CreateEvent extends Event {
    public Devise getDevise() {
        return devise;
    }

    private Devise devise;

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public CreateEvent(Devise devise){
     super(EventType.CREATE);
     this.devise=devise;

 }


}
