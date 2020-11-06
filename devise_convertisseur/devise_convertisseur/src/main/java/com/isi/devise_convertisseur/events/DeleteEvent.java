package com.isi.devise_convertisseur.events;

import com.isi.devise_convertisseur.model.EventType;

public class DeleteEvent extends Event {
    private String name;

    public String getName() {
        return name;
    }

    public DeleteEvent(String name)
    {
        super(EventType.DELETE);
        this.name=name;
    }
}
