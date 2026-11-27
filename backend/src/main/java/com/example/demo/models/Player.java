package com.example.demo;

public class Player {

    // Attributs
    private String name;
    private Campaign campaign;

    // Constructeur
    public Player(String name, Campaign campaign) {

        if (campaign == null) {
            throw new IllegalArgumentException("La campagne ne peut pas être null.");
        }

        this.name = name;
        this.campaign = campaign;
    }

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
    }
}