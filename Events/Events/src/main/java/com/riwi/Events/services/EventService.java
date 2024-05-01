package com.riwi.Events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Events.entities.Events;
import com.riwi.Events.reposiroties.EventRepository;
import com.riwi.Events.services.serviceAbstract.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
    
    @Autowired
    private final EventRepository objEventRepository;

    @Override
    public Events add(Events objEvent) {
         return this.objEventRepository.save(objEvent);
    }

    @Override
    public Page<Events> getAll(int page, int size) {
        if (page < 0) {
            page = 1;
        }
        PageRequest pagination = PageRequest.of(page, size);
        return this.objEventRepository.findAll(pagination);
    }

    @Override
    public Events findById(String id_Event) {
        return this.objEventRepository.findById(id_Event).orElseThrow();
    }

    @Override
    public Events update(String id_Event, Events objEvent) {
        this.objEventRepository.findById(id_Event).orElseThrow();
        objEvent.setId_Event(id_Event);
        return this.objEventRepository.save(objEvent);
    }

    @Override
    public void delete(String id_Event) {
        Events objEvent = this.objEventRepository.findById(id_Event).orElseThrow();
        this.objEventRepository.delete(objEvent);
    }
    
    
}
