package dev.lightdream.pokebounties.dto;

import dev.lightdream.pokebounties.Main;
import lombok.NoArgsConstructor;
import org.spongepowered.api.event.filter.cause.All;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
public class Data {

    public HashMap<String, DailyQuest> quests = new HashMap<>(); // Day.Month.Year -> DailyQuest

    public void deleteQuest(String date){
        quests.remove(date);
        Main.instance.fileManager.save(this);
    }

    public void createQuest(String date, DailyQuest quest){
        quests.put(date, quest);
        Main.instance.fileManager.save(this);
    }

    public List<String> getDates(){
        return new ArrayList<>(quests.keySet());
    }
}
