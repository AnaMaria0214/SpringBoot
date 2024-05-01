package com.riwi.Events.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Events.entities.Events;
import com.riwi.Events.services.serviceAbstract.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private final IEventService objIEventService;

    @GetMapping
    public ResponseEntity<Page<Events>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.objIEventService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id_Event}")
    public ResponseEntity<Events> get(@PathVariable String id_Event) {
        return ResponseEntity.ok(this.objIEventService.findById(id_Event));
    }

    @PostMapping
    public ResponseEntity<Events> add(@RequestBody Events objEvent) {
        return ResponseEntity.ok(this.objIEventService.add(objEvent));
    }

    @PutMapping(path = "/{id_Event}")
    public ResponseEntity<Events> update(@PathVariable String id_Event, @RequestBody Events objEvent) {
        return ResponseEntity.ok(this.objIEventService.update(id_Event, objEvent));
    }

    @DeleteMapping(path = "/{id_Event}")
    public ResponseEntity<Void> delete(@PathVariable String id_Event) {
        this.objIEventService.delete(id_Event);
        return ResponseEntity.noContent().build();
    }
    
}
