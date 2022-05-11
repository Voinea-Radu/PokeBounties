package dev.lightdream.pokebounties.manager;

import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.dto.DailyQuest;
import dev.lightdream.pokebounties.dto.Quest;
import dev.lightdream.pokebounties.dto.Reward;
import dev.lightdream.pokebounties.utils.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {

    public ScheduleManager() {

    }

    public void registerDailyGeneration() {

    }

    private void checkGenerationNeeds() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < 21; i++) {
            LocalDateTime then = now.plusDays(i);
            String date = formatter.format(now);

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

            Duration duration = Duration.between(time, now);
            if (duration.toDays() > 14) {
                remove.add(key);
            }
        });

        remove.forEach(key -> {
            Main.instance.data.deleteQuest(key);
        });
    }

    private DailyQuest generateDailyQuest() {
        List<Quest> quests = new ArrayList<>();
        for (int i = 0; i < Main.instance.config.dailyQuests; i++) {
            int rnd1 = Utils.generateRandom(0, Main.instance.pokemonList.pokemons.size() - 1);
            int rnd2 = Utils.generateRandom(0, Main.instance.config.questRewards.size() - 1);

            String pokemon = Main.instance.pokemonList.pokemons.get(rnd1);
            Reward reward = Main.instance.config.questRewards.get(rnd2);

            Quest quest = new Quest(pokemon, reward);
            quests.add(quest);
        }

        return new DailyQuest(quests);
    }

}
