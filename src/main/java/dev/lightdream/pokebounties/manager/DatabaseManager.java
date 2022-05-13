package dev.lightdream.pokebounties.manager;

import com.google.gson.Gson;
import dev.lightdream.databasemanager.database.ProgrammaticHikariDatabaseManager;
import dev.lightdream.databasemanager.dto.QueryConstrains;
import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.database.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.api.entity.living.player.Player;

import java.util.HashMap;
import java.util.UUID;

@SuppressWarnings("unused")
public class DatabaseManager extends ProgrammaticHikariDatabaseManager {

    public DatabaseManager() {
        super(Main.instance);
    }

    @Override
    public void setup() {
        registerDataType(HashMap.class, "TEXT");

        registerSDPair(
                HashMap.class,
                map -> new Gson().toJson(map),
                json -> new Gson().fromJson(json.toString(), HashMap.class)
        );

        setup(User.class);
    }


    @SuppressWarnings("unused")
    public @NotNull User createUser(@NotNull Player player) {
        User user = getUser(player.getUniqueId());
        if (user == null) {
            user = getUser(player.getName());
        }
        if (user != null) {
            user.uuid = player.getUniqueId();
        } else {
            user = new User(player.getUniqueId(), player.getName());
        }
        user.save();
        return user;
    }

    public @Nullable User getUser(@NotNull UUID uuid) {
        return get(User.class).query(new QueryConstrains().equals("uuid", uuid))
                .query()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings("unused")
    public @Nullable User getUser(@NotNull String name) {
        return get(User.class).query(new QueryConstrains().equals("name", name))
                .query()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings("unused")
    public @NotNull User getUser(@NotNull Player player) {
        return createUser(player);
    }

    @SuppressWarnings("unused")
    public @Nullable User getUser(int id) {
        return get(User.class).query(new QueryConstrains().equals("id", id))
                .query()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
