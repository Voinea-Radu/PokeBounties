package dev.lightdream.pokebounties.manager;

import dev.lightdream.logger.Debugger;
import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.dto.DailyQuest;
import dev.lightdream.pokebounties.dto.Quest;
import dev.lightdream.pokebounties.dto.Reward;
import dev.lightdream.pokebounties.utils.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleManager {

    public ScheduleManager() {
        registerDailyGeneration();
    }

    public void registerDailyGeneration() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Debugger.log("Generating daily quests...");
                checkGenerationNeeds();
            }
        }, 0, 60 * 1000);
    }

    private void checkGenerationNeeds() {

        for (int i = 0; i < 21; i++) {
            LocalDateTime then = Utils.getDate().plusDays(i);
            String date = Utils.formatter.format(then);

            Main.instance.data.createQuest(date, generateDailyQuest());
        }

        List<String> remove = new ArrayList<>();

        Main.instance.data.getDates().forEach(key -> {
            String dayString = key.split("\\.")[0];
            String monthString = key.split("\\.")[1];
            String yearString = key.split("\\.")[2];

            int day = Integer.parseInt(dayString);
            int month = Integer.parseInt(monthString);
            int year = Integer.parseInt(yearString);

            LocalDateTime time = LocalDateTime.of(year, month, day, 0, 0);

            Duration duration = Duration.between(time, Utils.getDate());
            if (duration.toDays() > 14) {
                remove.add(key);
            }
        });

        remove.forEach(key ->
                Main.instance.data.deleteQuest(key));
    }

    private DailyQuest generateDailyQuest() {
        List<Quest> quests = new ArrayList<>();
        for (int i = 0; i < Main.instance.config.dailyQuests; i++) {
            int rnd1 = Utils.generateRandom(0, Main.instance.pokemonList.pokemons.size());
            int rnd2 = Utils.generateRandom(0, Main.instance.config.questRewards.size());

            String pokemon = Main.instance.pokemonList.pokemons.get(rnd1);
            Reward reward = Main.instance.config.questRewards.get(rnd2);

            Quest quest = new Quest(pokemon, reward);
            quests.add(quest);
        }

        return new DailyQuest(quests);
    }

}
