package dev.lightdream.pokebounties.dto;

import dev.lightdream.messagebuilder.MessageBuilder;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;

public class RewardLevel {

    public String title;
    public String description;
    public MessageBuilder command;

    public RewardLevel(String title, String description, MessageBuilder command) {
        this.title = title;
        this.description = description;
        this.command = command;
    }

    @SuppressWarnings("unused")
    public RewardLevel() {
    }

    public void give(String username) {
        Sponge.getServer().getConsole().sendMessage(Text.of(
                command
                        .parse("player", username)
                        .parse()
        ));
    }

    @Override
    public String toString() {
        return "RewardLevel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", command=" + command +
                '}';
    }
}
