package dev.lightdream.pokebounties.database;

import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.logger.Debugger;
import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.dto.Quest;
import dev.lightdream.pokebounties.utils.Utils;
import org.spongepowered.api.entity.living.player.Player;

import java.util.HashMap;
import java.util.UUID;

public class User {

    public UUID uuid;
    public String name;
    public String date;
    public HashMap<String, Integer> levelFinished;

    public User(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.date = Utils.getDateString();
        this.levelFinished = new HashMap<>();
    }

    public static User getUser(Player player) {
        return Main.developer;
    }

    public int getLevelToFinish(Quest quest) {
        return this.levelFinished.getOrDefault(quest.pokemon, 0);
    }

    public int getPokemonLevel(Quest quest) {
        return Main.instance.config.getPokeMonLevel(getLevelToFinish(quest));
    }

    public void finishLevel(Quest quest, EnumSpecies species, int level) {
        Debugger.log("Finish level " + level + " for " + species.name);
        if (getPokemonLevel(quest) != level) {
            return;
        }

        if (!quest.pokemon.equals(species.toString())) {
            return;
        }

        this.levelFinished.put(quest.pokemon, this.levelFinished.getOrDefault(quest.pokemon, 0) + 1);
        quest.reward.rewards.get(this.levelFinished.get(quest.pokemon)).give(this.name);
        Debugger.log(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", levelFinished=" + levelFinished +
                '}';
    }
}
