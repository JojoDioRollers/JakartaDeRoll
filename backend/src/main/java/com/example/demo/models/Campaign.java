<<<<<<< HEAD
package com.example.demo;

public class Campaign {

    // Attributs
    private String name;
    private Player gamemaster;
    private String description;

    // Constructeur
=======
package com.example.demo.models;

import java.util.HashSet;
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
/**
 * Class for a Campaign
 */
public class Campaign {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int campaignID; //< Campaign ID

    @Column 
    private String name; //< Campaign name

    @ManyToOne 
    @JoinColumn(name="playerID") 
    private Player gamemaster; //< Campaign gamemaster

    @Column 
    private String description; //< Campaign description

    @ManyToMany 
    @JoinColumn(name="playerID")
    private Set<Player> players; //< All the players in the campaign

    /**
     * Constructor for the campaign
     * @param gamemaster gamemaster of the campaign
     * @param name name of the campaign
     */
>>>>>>> origin/rework
    public Campaign(Player gamemaster, String name) {

        if (gamemaster == null) {
            throw new IllegalArgumentException("Le gamemaster ne peut pas être null.");
        }

        this.gamemaster = gamemaster;
        this.name = name;
        this.description = "";
    }

<<<<<<< HEAD
    // Getters
    public String getName() {
        return name;
    }

    public Player getGamemaster() {
        return gamemaster;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPlayer(Campaign campaign, Player player) {
=======
    /**
     * Adds a player to the campaign
     * @param player player to add
     */
    public void addPlayer(Player player) {
        //TODO addPlayer method
>>>>>>> origin/rework
    // Vérifier que le joueur n'est pas le MJ
    // Vérifier qu'il n'est pas déjà inscrit
    // Enregistrer l'association en BDD
    }

<<<<<<< HEAD
    public Player getPlayers(Campaign campaign) {
    // Requête BDD pour récupérer les joueurs
    // Exclure le gamemaster
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", gamemaster=" + gamemaster.getName() +
                ", description='" + description + '\'' +
                '}';
=======
    /**
     * Returns all the player except the gamemaster
     * @return set of players
     */
    public Set<Player> getPlayers() {
        Set<Player> playersToReturn = new HashSet<>();

        for (Player player : players) {
            if (!player.equals(gamemaster)) {
                playersToReturn.add(player);
            }
        }
        return playersToReturn;
    }

    @Override
    /**    (non-Javadoc)
     * Redefining toString method
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String str = "";

        str += name + "\n";
        str += "Gamemaster : " + gamemaster.getName() + "\n\n";
        str += "List of players:\n";

        for (Player player : players) {
            if (!player.equals(gamemaster)) {
                str += "- " + player.getName() + "\n";
            }
        }

        str += "\nDescription:\n" + description;
        

        return str;
>>>>>>> origin/rework
    }
}
