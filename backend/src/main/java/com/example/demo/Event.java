package com.example.demo;

import java.util.ArrayList;
import java.util.List;
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

    public void addSession(Session session) {
        this.sessions.add(session);
    }

    public void addChars(List<Character> characters) {
        for (Character character : characters) {
            this.characters.add(character);
        }
    }

    public void addChars(Set<Character> characters) {
        for (Character character : characters) {
            this.characters.add(character);
        }
    }

    public void addChars(Character character) {
        this.characters.add(character);
    }

    public void addEvent(String name) {
        this.events.add(new Event(name, this.campaign));
    }

    public Set<Character> getInvolved() {
        return this.characters;
    }

    @Override 
    public String toString() {
        String str = "";
        ArrayList<Character> tmp = new ArrayList<>();

        str += "Event : " + this.name + "\n\nPlayed characters:\n";

        for (Character character : this.characters) {
            if (character.getPlayer().equals(this.campaign.getGamemaster())) {
                str += "- " + character.getName() + "\n";
            } else {
                tmp.add(character);
            }
        }

        str += "\nNon playable characters:\n";

        for (Character character : tmp) {
            str += "- " + character.getName() + "\n";
        }

        str += "\nDescription:\n" + this.description;

        return str;
    }

}
