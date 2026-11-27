package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity 
/**
 * Class for ingame events
 */
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int eventID; //< Event ID

    @Column(name = "name")
    private String name; //< Event name

    @Column(name="description")
    private String description; //< Event Description

    @OneToOne 
    @JoinColumn(name="campaignID")
    private Campaign campaign; //< Campaign associated to the event

    @OneToMany
    @JoinColumn(name="eventID")
    private Set<Event> events; //< Potential subevents to this event

    @ManyToMany
    @JoinColumn(name="characterID")
    private Set<CharacterGame> characters; //< Characters involved with this event

    @ManyToMany
    @JoinColumn(name="sessionID")
    private Set<Session> sessions; //< Sessions where this event appeared
    
    /**
     * Constructor for Event
     * @param name event name
     * @param campaign campaign associated
     */
    public Event(String name, Campaign campaign) {
        this.name = name;
        this.campaign = campaign;
    }

    /**
     * Add a session to the set of sessions
     * @param session session to add
     */
    public void addSession(Session session) {
        this.sessions.add(session);
    }

    /**
     * Add a list of characters to the set of characters involved in the event
     * @param characters characters involved
     */
    public void addChars(List<CharacterGame> characters) {
        for (CharacterGame character : characters) {
            this.characters.add(character);
        }
    }

    /**
     * Add a set of characters to the set of characters involved in the event
     * @param characters characters involved
     */
    public void addChars(Set<CharacterGame> characters) {
        for (CharacterGame character : characters) {
            this.characters.add(character);
        }
    }

    /**
     * Add a character to the set of characters involved in the event
     * @param character character involved
     */
    public void addChars(CharacterGame character) {
        this.characters.add(character);
    }

    /**
     * Add a subevent to this event
     * @param name name of the event
     * 
     * The event is created in the method then added to the set of subevents
     */
    public void addEvent(String name) {
        this.events.add(new Event(name, this.campaign));
    }

    /**
     * Returns all the characters involved in the event
     * @return Set of characters involved in the event
     */
    public Set<CharacterGame> getInvolved() {
        return this.characters;
    }

    /**    (non-Javadoc)
     * Redefining the toString method
     * @see java.lang.Object#toString()
     */
    @Override 
    public String toString() {
        String str = "";
        ArrayList<CharacterGame> tmp = new ArrayList<>();

        str += "Event : " + this.name + "\n\nPlayed characters:\n";

        for (CharacterGame character : this.characters) {
            if (!character.getPlayer().equals(this.campaign.getGamemaster())) {
                str += "- " + character.getName() + "\n";
            } else {
                tmp.add(character);
            }
        }

        str += "\nNon playable characters:\n";

        for (CharacterGame character : tmp) {
            str += "- " + character.getName() + "\n";
        }

        str += "\nDescription:\n" + this.description;

        return str;
    }

}
