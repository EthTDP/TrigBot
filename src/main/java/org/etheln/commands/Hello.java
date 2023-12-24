package org.etheln.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class Hello implements CommandInterface {

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public String getDescription() {
        return "says hello";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Hello!").queue();
    }
}
