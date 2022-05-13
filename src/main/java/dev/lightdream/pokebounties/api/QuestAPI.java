package dev.lightdream.pokebounties.api;

import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.dto.DailyQuest;

import java.util.HashMap;
import java.util.List;

public class QuestAPI {

    public static HashMap<String, DailyQuest> getGeneratedQuests() {
        return Main.instance.data.quests;
    }

    public static DailyQuest getQuest(String date) {
        return Main.instance.data.getDailyQuest(date);
    }

    public static DailyQuest getQuest() {
        return Main.instance.data.getDailyQuest();
    }

    public static List<String> getGeneratedDates() {
        return Main.instance.data.getDates();
    }

}
