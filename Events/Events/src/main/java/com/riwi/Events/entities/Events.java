package com.riwi.Events.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_Event;
    @Column( length = 20 , nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate date;
    @Column( length = 20 , nullable = false)
    private String location;
    @Column ( length = 255 , nullable = false)
    private int capacity;
}
