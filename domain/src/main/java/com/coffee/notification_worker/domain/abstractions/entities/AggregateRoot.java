package com.coffee.notification_worker.domain.abstractions.entities;

import com.coffee.notification_worker.domain.abstractions.events.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot {

    private final List<DomainEvent> events = new ArrayList<>();

    protected void addEvent(DomainEvent event) {
        events.add(event);
    }

    public List<DomainEvent> getEvents() {
        return new ArrayList<>(events);
    }
}
