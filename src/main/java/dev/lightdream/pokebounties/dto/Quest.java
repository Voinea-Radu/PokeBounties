package dev.lightdream.pokebounties.dto;

public class Quest {

    public String pokemon;
    public Reward reward;

    public Quest(String pokemon, Reward reward) {
        this.pokemon = pokemon;
        this.reward = reward;
    }

    @SuppressWarnings("unused")
    public Quest() {
    }
}
