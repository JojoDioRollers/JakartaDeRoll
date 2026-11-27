<<<<<<< HEAD
package com.example.demo;

public class Player {

    // Attributs
    private String name;
    private Campaign campaign;

    // Constructeur
=======
package com.example.demo.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data 
@Entity 
/**
 * Class for a human player
 */
public class Player {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int playerID; //< Player ID

    @Column 
    private String name; //< Player name
    
    @ManyToMany
    @JoinColumn(name="campaignID")
    private Campaign campaign; //< The campaign the player is playing in

    @ManyToMany
    @JoinColumn(name="sessionID")
    private Set<Session> sessions; //< All the sessions the player was in

    /**
     * Constructor for Player
     * @param name Player's name
     * @param campaign Campaign the player is in
     */
>>>>>>> origin/rework
    public Player(String name, Campaign campaign) {

        if (campaign == null) {
            throw new IllegalArgumentException("La campagne ne peut pas être null.");
        }

        this.name = name;
        this.campaign = campaign;
    }

<<<<<<< HEAD
    // Getters
    public String getName() {
        return name;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
=======
    @Override
    /**    (non-Javadoc)
     * Redefining toString method
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Player name : " + name;
>>>>>>> origin/rework
    }
}