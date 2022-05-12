package dev.lightdream.pokebounties.manager;

import com.pixelmongenerations.api.events.battles.BattleEndEvent;
import com.pixelmongenerations.common.battle.controller.participants.PixelmonWrapper;
import com.pixelmongenerations.common.battle.controller.participants.PlayerParticipant;
import com.pixelmongenerations.common.battle.controller.participants.WildPixelmonParticipant;
import com.pixelmongenerations.common.entity.pixelmon.EntityPixelmon;
import com.pixelmongenerations.common.entity.pixelmon.stats.Level;
import com.pixelmongenerations.core.enums.EnumSpecies;
import dev.lightdream.logger.Debugger;
import dev.lightdream.pokebounties.Main;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForgeEventManager {

    public ForgeEventManager() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBattleEnd(BattleEndEvent event) {
        event.getPlayers();
        event.getBattleResults().keySet().forEach(key -> {

        });

        List<EntityPlayerMP> players = new ArrayList<>();
        HashMap<EnumSpecies, Integer> pokemons = new HashMap<>();

        event.getBattleController().participants.forEach(participant -> {
            if (participant instanceof PlayerParticipant) {
                PlayerParticipant player = (PlayerParticipant) participant;
                if (player.isDefeated) {
                    return;
                }
                players.add(player.player);
            } else {
                WildPixelmonParticipant pixelmonParticipand = (WildPixelmonParticipant) participant;
                if (!participant.isDefeated) {
                    return;
                }
                PixelmonWrapper pixelmonWrapper = pixelmonParticipand.getPokemon();
                EntityPixelmon pixelmon = pixelmonWrapper.pokemon;
                EnumSpecies species = pixelmon.getSpecies();
                Level level = pixelmon.level;
                int levelAmount = level.getLevel();
                pokemons.put(species, levelAmount);
            }
        });

        Debugger.log("Players: " + players);
        Debugger.log("Pokemons: " + pokemons);

        players.forEach(player -> {
            pokemons.forEach((species, levelAmount) -> {
                Main.instance.questManager.submitQuest((Player) player, species, levelAmount);
            });
        });
    }

}
