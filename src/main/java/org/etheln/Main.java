package org.etheln;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.etheln.commands.CommandManager;
import org.etheln.commands.Hello;
import org.etheln.commands.Trig;

public class Main {
    public static void main(String[] args) {

        JDA jda = JDABuilder.createDefault(args[0])
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_PRESENCES)
                .setActivity(Activity.streaming("Nevermore by The Sapphire Sound", "https://www.youtube.com/watch?v=Rjp7HjMqFEk"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();

        jda.addEventListener(new Trig());
        jda.addEventListener(new ReactionEvent());

        CommandManager cm = new CommandManager();

        cm.add(new Hello());
        cm.add(new Trig());

        jda.addEventListener(cm);
    }
}