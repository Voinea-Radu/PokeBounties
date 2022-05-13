package dev.lightdream.pokebounties.database;

import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.databasemanager.annotations.database.DatabaseField;
import dev.lightdream.databasemanager.annotations.database.DatabaseTable;
import dev.lightdream.databasemanager.dto.entry.impl.IntegerDatabaseEntry;
import dev.lightdream.logger.Debugger;
import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.api.BountyUser;
import dev.lightdream.pokebounties.dto.Quest;
import org.spongepowered.api.entity.living.player.Player;

import java.util.HashMap;
import java.util.UUID;

@DatabaseTable(table = "users")
public class User extends IntegerDatabaseEntry implements BountyUser {

    @DatabaseField(columnName = "uuid")
    public UUID uuid;
    @DatabaseField(columnName = "name")
    public String name;
    @DatabaseField(columnName = "level_finished")
    public HashMap<String, Integer> levelFinished = new HashMap<>(); // Species, level

    public User(UUID uuid, String name) {
        super(Main.instance);
        this.uuid = uuid;
        this.name = name;
    }

    public User() {
        super(Main.instance);
    }

    public User(Player player) {
        this(player.getUniqueId(), player.getName());
    }

    public static User getUser(Player player) {
        return Main.instance.databaseManager.getUser(player);
    }

    private int getLevelToFinish(Quest quest) {
        return this.levelFinished.getOrDefault(quest.pokemon, 0) + 1;
    }

    private int getPokemonLevel(Quest quest) {
        return Main.instance.config.getPokeMonLevel(getLevelToFinish(quest));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    public void finishLevel(Quest quest, EnumSpecies species, int level) {
        Debugger.log("Finish level " + level + " for " + species.name);
        if (getPokemonLevel(quest) != level) {
            Debugger.log("[1] Level is not correct " + getPokemonLevel(quest) + " != " + level);
            return;
        }

        if (!quest.pokemon.equals(species.toString())) {
            Debugger.log(2);
            return;
        }

        Debugger.log(3);
        this.levelFinished.put(quest.pokemon, this.levelFinished.getOrDefault(quest.pokemon, 0) + 1);
        Debugger.log(quest);
        Debugger.log(quest.reward);
        Debugger.log(quest.reward.rewards);
        Debugger.log(this.levelFinished);
        Debugger.log(quest.pokemon);
        Debugger.log(this.levelFinished.get(quest.pokemon));
        Debugger.log(quest.reward.rewards.get(this.levelFinished.get(quest.pokemon)));
        Debugger.log(this.name);
        quest.reward.rewards.get(this.levelFinished.get(quest.pokemon)).give(this.name);
        Debugger.log(this);
        save();
    }

    @Override
    public int getLevelOfQuest(Quest quest) {
        return levelFinished.getOrDefault(quest.pokemon, 0);
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", levelFinished=" + levelFinished +
                '}';
    }
}
