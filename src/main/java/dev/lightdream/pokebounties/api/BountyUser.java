package dev.lightdream.pokebounties.api;

import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.pokebounties.database.User;
import dev.lightdream.pokebounties.dto.Quest;
import org.spongepowered.api.entity.living.player.Player;

import java.util.UUID;

public interface BountyUser {

    public static BountyUser getUser(Player player){
        return User.getUser(player);
    }

    String getName();

    @SuppressWarnings("unused")
    UUID getUUID();

    void finishLevel(Quest quest, EnumSpecies species, int level);

    @SuppressWarnings("unused")
    int getLevelOfQuest(Quest quest);

}
