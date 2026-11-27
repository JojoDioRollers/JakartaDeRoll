package com.example.demo;

public class Campaign {

    // Attributs
    private String name;
    private Player gamemaster;
    private String description;

    // Constructeur
    public Campaign(Player gamemaster, String name) {

        if (gamemaster == null) {
            throw new IllegalArgumentException("Le gamemaster ne peut pas être null.");
        }

        this.gamemaster = gamemaster;
        this.name = name;
        this.description = "";
    }

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
    // Vérifier que le joueur n'est pas le MJ
    // Vérifier qu'il n'est pas déjà inscrit
    // Enregistrer l'association en BDD
    }

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
    }
}
