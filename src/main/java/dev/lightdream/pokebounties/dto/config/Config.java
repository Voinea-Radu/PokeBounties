package dev.lightdream.pokebounties.dto.config;

import com.google.gson.annotations.Expose;
import dev.lightdream.messagebuilder.MessageBuilder;
import dev.lightdream.pokebounties.dto.Reward;
import dev.lightdream.pokebounties.dto.RewardLevel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Config {

    public boolean debug = true;
    public int dailyQuests = 2;
    public List<Reward> questRewards = Arrays.asList(
            new Reward(Arrays.asList(
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.1")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.2")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.3")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.4")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.5")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.6")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.7")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.8")),
                    new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.9"))
            ))
    );
    @Expose
    private HashMap<Integer, Integer> pokemonLevels = new HashMap<Integer, Integer>() {{
        put(1, 5);
        put(2, 10);
        put(3, 15);
        put(4, 20);
        put(5, 25);
        put(6, 30);
        put(7, 35);
        put(8, 40);
        put(9, 45);
    }}; // Quest Level -> Pokemon Level

    public int getPokeMonLevel(int questLevel) {
        return pokemonLevels.getOrDefault(questLevel, -1);
    }

}
