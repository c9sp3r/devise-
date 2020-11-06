package com.isi.devise_convertisseur.events;

import com.isi.devise_convertisseur.model.EventType;

public class Event {
    private EventType type;

    public void setType(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public Event(EventType type) {
        this.type = type;
    }

    public Event() {
    }
}
