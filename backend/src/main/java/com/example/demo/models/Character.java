package com.example.demo;

public class Character {

    // Attributs
    private String name;
    private String description;
    private String notes;

    private Campaign campaign;
    private Player player;

    // Constructeur
    public Character(String name, String description, String notes, Campaign campaign) {

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

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public Player getPlayer() {
        return player;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Changer le joueur associé au personnage
    public void setPlayer(Player newPlayer) {

        if (newPlayer != null && newPlayer.getCampaign() != this.campaign) {
            throw new IllegalArgumentException(
                "Le joueur et le personnage doivent appartenir à la même campagne."
            );
        }

        this.player = newPlayer;
    }

    // Effectuer un jet de dés
    public int roll(Roll type) {

        if (type == null) {
            throw new IllegalArgumentException("Le type de dé ne peut pas être null.");
        }

        return type.roll();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}