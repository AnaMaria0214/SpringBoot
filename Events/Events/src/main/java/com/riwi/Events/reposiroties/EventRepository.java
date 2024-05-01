package com.riwi.Events.reposiroties;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Events.entities.Events;

public interface EventRepository extends JpaRepository<Events, String>{

}