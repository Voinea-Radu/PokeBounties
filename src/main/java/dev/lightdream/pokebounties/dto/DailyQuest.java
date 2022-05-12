package dev.lightdream.pokebounties.dto;

import java.util.List;

public class DailyQuest {

    public List<Quest> quests;

    public DailyQuest() {
    }

    public DailyQuest(List<Quest> quests) {
        this.quests = quests;
    }
}
