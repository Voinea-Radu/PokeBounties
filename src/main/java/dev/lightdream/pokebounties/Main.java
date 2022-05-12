package dev.lightdream.pokebounties;

import dev.lightdream.filemanager.FileManager;
import dev.lightdream.filemanager.FileManagerMain;
import dev.lightdream.logger.LoggableMain;
import dev.lightdream.logger.Logger;
import dev.lightdream.messagebuilder.MessageBuilderManager;
import dev.lightdream.pokebounties.database.User;
import dev.lightdream.pokebounties.dto.Data;
import dev.lightdream.pokebounties.dto.config.Config;
import dev.lightdream.pokebounties.dto.config.PokemonList;
import dev.lightdream.pokebounties.manager.ForgeEventManager;
import dev.lightdream.pokebounties.manager.QuestManager;
import dev.lightdream.pokebounties.manager.ScheduleManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;
import java.util.UUID;

@Plugin(
        id = "pokebounties",
        name = "PokeBounties",
        url = "https://lightdream.dev",
        authors = {
                "LightDream"
        }
)
public class Main implements FileManagerMain, LoggableMain {

    // Static
    public static Main instance;
    public static User developer = new User(UUID.randomUUID(), "_LightDream");

    // Config & Data
    public Data data;
    public Config config;
    public PokemonList pokemonList;

    // Manager
    public FileManager fileManager;
    public ForgeEventManager forgeEventManager;
    public QuestManager questManager;
    public ScheduleManager scheduleManager;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        instance = this;
        Logger.init(this);

        fileManager = new FileManager(this);
        MessageBuilderManager.init(fileManager);
        loadConfigs();

        questManager = new QuestManager();
        forgeEventManager = new ForgeEventManager();
        scheduleManager = new ScheduleManager();
    }

    @Listener
    public void onEnable(GameStartingServerEvent event) {
        forgeEventManager = new ForgeEventManager();
    }

    private void loadConfigs() {
        this.config = this.fileManager.load(Config.class);
        this.data = this.fileManager.load(Data.class);
        this.pokemonList = this.fileManager.load(PokemonList.class);
    }

    @Override
    public File getDataFolder() {
        return new File(System.getProperty("user.dir") + "/config/PokeBounties");
    }

    @Override
    public boolean debug() {
        return config.debug;
    }

    @Override
    public void log(String s) {
        System.out.println(s);
    }
}
