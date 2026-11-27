package com.example.demo.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data 
@Entity 
public class Session {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int sessionID; //< Session ID

    @Column 
    private String description; //< Session description

    @Column 
    private Date date;

    @ManyToMany 
    @JoinColumn(name="eventID")
    private Set<Event> events; //< All the events that happened in the session

    @ManyToMany 
    @JoinColumn(name="playerID")
    private Set<Player> players; //< All the player involved in a session

    @ManyToOne 
    @JoinColumn(name="campaignID")
    private Campaign campaign; //< Campaign associated to this session

    /**
     * Constructor for Session
     * @param players set of players
     * @note The gamemaster should not be in the list as they are already included in the campaign attribute.
     */
    public Session(Set<Player> players) {
        for (Player player : players) {
            if (player.equals(campaign.getGamemaster())) {
                System.out.println("List of players in argument shoudn't include the gamemaster !");
                continue;
            }
            this.players.add(player);
        }
    }
    
    /**
     * Constructor for Session
     * @param players list of players
     * @note The gamemaster should not be in the list as they are already included in the campaign attribute.
     */
    public Session(List<Player> players) {
        for (Player player : players) {
            if (player.equals(campaign.getGamemaster())) {
                System.out.println("List of players in argument shoudn't include the gamemaster !");
                continue;
            }
            this.players.add(player);
        }
    }

    /**
     * Add a player to the present players
     * @param player player to add
     */
    public void addPlayer(Player player) {
        // TODO with API
    }

    
}
