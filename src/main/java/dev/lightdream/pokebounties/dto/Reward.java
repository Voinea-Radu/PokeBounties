package dev.lightdream.pokebounties.dto;

import java.util.List;

public class Reward {

    public List<RewardLevel> rewards;

    public Reward(List<RewardLevel> rewards) {
        this.rewards = rewards;
    }

    @SuppressWarnings("unused")
    public Reward() {
    }
}
