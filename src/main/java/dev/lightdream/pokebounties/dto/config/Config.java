package dev.lightdream.pokebounties.dto.config;

import com.google.gson.annotations.Expose;
import dev.lightdream.messagebuilder.MessageBuilder;
import dev.lightdream.pokebounties.dto.Reward;
import dev.lightdream.pokebounties.dto.RewardLevel;

import java.util.Arrays;
import java.util.HashMap;

public class Config {

    public boolean debug = true;
    public int dailyQuests = 2;

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

    public HashMap<Integer, Reward> questRewards = new HashMap<Integer, Reward>() {{
        put(1, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 1.3"))
        )));
        put(2, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 2.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 2.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 2.3"))
        )));
        put(3, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 3.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 3.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 3.3"))
        )));
        put(4, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 4.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 4.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 4.3"))
        )));
        put(5, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 5.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 5.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 5.3"))
        )));
        put(6, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 6.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 6.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 6.3"))
        )));
        put(7, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 7.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 7.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 7.3"))
        )));
        put(8, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 8.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 8.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 8.3"))
        )));
        put(9, new Reward(Arrays.asList(
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 9.1")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 9.2")),
                new RewardLevel("One epic command", "This reward is going to make the server say a number", new MessageBuilder("say 9.3"))
        )));
    }}; // Quest Level -> List of possible Rewards

}
