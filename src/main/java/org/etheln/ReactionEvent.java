package org.etheln;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.UnicodeEmoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.etheln.commands.Trig;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static org.etheln.commands.Trig.play;

public class ReactionEvent extends ListenerAdapter {
    @SubscribeEvent
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if(Objects.requireNonNull(event.getUser()).isBot())
            return;

        if(event.getReaction().getEmoji().asUnicode().equals(Emoji.fromUnicode("U+1F1FE")) && !Trig.start) {
            play();

            Trig.radians.add("PI/3");
            Trig.radians.add("PI/6");
            Trig.radians.add("0");
            Trig.radians.add("PI/2");
            Trig.radians.add("PI/4");
            Trig.radians.add("2PI/3");
            Trig.radians.add("3PI/4");
            Trig.radians.add("5PI/6");
            Trig.radians.add("PI");
            Trig.radians.add("7PI/6");
            Trig.radians.add("5PI/4");
            Trig.radians.add("4PI/3");
            Trig.radians.add("3PI/2");
            Trig.radians.add("5PI/3");
            Trig.radians.add("7PI/4");
            Trig.radians.add("11PI/6");

            event.getChannel().sendMessage("What is the " + Trig.trig + " of " + Trig.radians.get(Trig.randForCalc)).queue();
        }

        if(event.getReaction().getEmoji().asUnicode().equals(Emoji.fromUnicode("U+1F1F3")) && !Trig.start) {
            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("Trig Results");
            eb.setThumbnail(Trig.originalUser.getAvatarUrl());
            eb.setDescription("Going to display your trig results, thanks for using TrigBot.");
            eb.addField("Results for:", Objects.requireNonNull(Trig.originalUser.getGlobalName()), false);
            eb.addField("Correct", String.valueOf(Trig.correct.get(Trig.originalUser)), true);
            eb.addField("Total", String.valueOf(Trig.total), true);
            eb.addField("Result: ", "You got " + Trig.correct.get(Trig.originalUser) + "/" + Trig.total, true);
            double percent = (double) Trig.correct.get(Trig.originalUser) / Trig.total;

            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.CEILING);
            eb.addField("Result as percentage: ", df.format(percent * 100) + "%", true);

            char letter;

            if(percent*100 >= 90) {
                letter = 'A';
            } else if(percent*100 >= 80) {
                letter = 'B';
            } else if(percent*100 >= 70) {
                letter = 'C';
            } else if(percent*100 >=60) {
                letter = 'D';
            } else {
                letter = 'F';
            }
            eb.addField("Result as Letter Grade", "" + letter, true);

            eb.setColor(Color.ORANGE);

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date();

            eb.setFooter("Finished using @ " + formatter.format(date), Trig.originalUser.getAvatarUrl());

            event.getChannel().sendMessage("You were on a trig-streak of " + Trig.total + " but ended it. You were able to get " + Trig.correct.get(Trig.originalUser) + " out of " + Trig.total + " correct!")
                    .addEmbeds(eb.build())
                    .queue();



            Trig.correct.put(Trig.originalUser, 0);
            Trig.total = 0;
            Trig.start = false;
        }
    }
}
