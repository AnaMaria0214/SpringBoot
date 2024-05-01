package com.riwi.Events.services.serviceAbstract;

import org.springframework.data.domain.Page;

import com.riwi.Events.entities.Events;

public interface IEventService {
    public Events add(Events objEvent);

    public Page<Events> getAll(int page, int size);

    public Events findById(String id);

    public Events update(String id, Events objEvent);

    public void delete(String id);
    
}
