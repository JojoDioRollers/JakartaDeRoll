package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data 
@Entity 
/**
 * Class for a Characyer
 */
public class CharacterGame {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int characterID; //< Character ID

    @Column 
    private String name; //< Character's name

    @Column 
    private String description; //< Character's description
    
    @Column 
    private String notes; //< Notes about this character

    @OneToOne
    @JoinColumn(name="campaignID") 
    private Campaign campaign; //< The campaign the character is in

    @ManyToOne 
    @JoinColumn(name="playerID")
    private Player player; //< Player associated to the character (default=gamemaster)

    /**
     * Constructor for the Character
     * @param name character's name
     * @param description character's description
     * @param notes notes about the character
     * @param campaign campaign the character is in
     */
    public CharacterGame(String name, String description, String notes, Campaign campaign) {

        if (campaign == null) {
            throw new IllegalArgumentException("La campagne ne peut pas être null.");
        }

        this.name = name;
        this.description = description;
        this.notes = notes;
        this.campaign = campaign;

        // Par défaut, le personnage est associé au MJ de la campagne
        setPlayer(campaign.getGamemaster());
    }

    /**
     * Roll a certain type of dice and return its value
     * @param Roll type of role
     * @return value of the rolled dice
     */
    public int roll(Roll type) {

        if (type == null) {
            throw new IllegalArgumentException("Le type de dé ne peut pas être null.");
        }

        return type.roll();
    }

    @Override
    /**    (non-Javadoc)
     * Redefining the toString method
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Character name : " + name + '\n' +
                "description : " + description + '\n' +
                "notes : " + notes;
    }
}