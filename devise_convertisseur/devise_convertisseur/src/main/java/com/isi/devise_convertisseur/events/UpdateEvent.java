package com.isi.devise_convertisseur.events;

import com.isi.devise_convertisseur.model.Devise;
import com.isi.devise_convertisseur.model.EventType;

public class UpdateEvent extends Event {
    public Devise getDevise() {
        return devise;
    }

    private Devise devise;

    public UpdateEvent(Devise devise){
        super(EventType.UPDATE);
        this.devise=devise;

    }



}
