package dev.lightdream.pokebounties.manager;

import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.pokebounties.Main;
import dev.lightdream.pokebounties.database.User;
import dev.lightdream.pokebounties.dto.DailyQuest;
import org.spongepowered.api.entity.living.player.Player;

public class QuestManager {

    public QuestManager() {

    }

    public void submitQuest(Player player, EnumSpecies species, int level) {
        DailyQuest dailyQuest = Main.instance.data.getDailyQuest();
        dailyQuest.quests.forEach(quest -> {
            User.getUser(player).finishLevel(quest, species, level);
        });
    }

}
