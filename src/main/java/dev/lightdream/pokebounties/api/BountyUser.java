package dev.lightdream.pokebounties.api;

import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.pokebounties.dto.Quest;

import java.util.UUID;

public interface BountyUser {

    String getName();

    UUID getUUID();

    void finishLevel(Quest quest, EnumSpecies species, int level);

    int getLevelOfQuest(Quest quest);

}
