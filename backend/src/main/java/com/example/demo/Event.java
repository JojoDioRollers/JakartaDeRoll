package com.example.demo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity 
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="campaign")
    private Campaign campaign;

    @OneToMany 
    private Set<Event> events;

    @ManyToMany 
    private Set<Character> characters;

    @ManyToMany 
    private Set<Session> sessions;
    
    public Event(String name, Campaign campaign) {
        this.name = name;
        this.campaign = campaign;
    }

}
