package dev.lightdream.pokebounties.dto;

import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.database.User;
import dev.lightdream.pokebounties.utils.Utils;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Data {

    public HashMap<String, DailyQuest> quests = new HashMap<>(); // Day.Month.Year -> DailyQuest

    public Data() {
    }

    public void deleteQuest(String date) {
        quests.remove(date);
        Main.instance.fileManager.save(this);
    }

    public void createQuest(String date, DailyQuest quest) {
        quests.put(date, quest);
        Main.instance.fileManager.save(this);
    }

    public DailyQuest getDailyQuest(String date) {
        return quests.get(date);
    }

    public DailyQuest getDailyQuest() {
        return getDailyQuest(Utils.getDateString());
    }

    public List<String> getDates() {
        return new ArrayList<>(quests.keySet());
    }
}
