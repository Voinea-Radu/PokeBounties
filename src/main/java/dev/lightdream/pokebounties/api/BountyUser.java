package dev.lightdream.pokebounties.api;

import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.pokebounties.dto.Quest;

import java.util.UUID;

public interface BountyUser {

    String getName();

    @SuppressWarnings("unused")
    UUID getUUID();

    void finishLevel(Quest quest, EnumSpecies species, int level);

    @SuppressWarnings("unused")
    int getLevelOfQuest(Quest quest);

}
