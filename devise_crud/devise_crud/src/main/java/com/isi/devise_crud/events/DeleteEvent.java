package com.isi.devise_crud.events;


import com.isi.devise_crud.model.EventType;

public class DeleteEvent extends Event {
    private String name;

    public String getName() {
        return name;
    }


    public DeleteEvent()
    {
        super(EventType.DELETE);


    }


    public DeleteEvent(String name)
    {
        super(EventType.DELETE);
        this.name=name;

    }
}
