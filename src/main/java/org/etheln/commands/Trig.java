package org.etheln.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Trig extends ListenerAdapter implements CommandInterface {
    public static boolean start = false;
    public static String trig;
    static ArrayList<Double> rad;
    public static ArrayList<String> radians = new ArrayList<>();
    public static int randForCalc;

    public static User originalUser;

    public static HashMap<User, Integer> correct;
    public static int total = 0;


    @Override
    public String getName() {
        return "trig";
    }

    @Override
    public String getDescription() {
        return "practice your trig";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        play();

        radians.add("PI/3");
        radians.add("PI/6");
        radians.add("0");
        radians.add("PI/2");
        radians.add("PI/4");
        radians.add("2PI/3");
        radians.add("3PI/4");
        radians.add("5PI/6");
        radians.add("PI");
        radians.add("7PI/6");
        radians.add("5PI/4");
        radians.add("4PI/3");
        radians.add("3PI/2");
        radians.add("5PI/3");
        radians.add("7PI/4");
        radians.add("11PI/6");

        originalUser = event.getUser();
        correct = new HashMap<>();

        correct.put(originalUser, 0);

        event.reply("What is the " + trig + " of " + radians.get(randForCalc)).queue();
    }

    @SubscribeEvent
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        String messageSent = event.getMessage().getContentRaw();

        if(event.getAuthor().isBot())
            return;

        if(originalUser == null)
            return;

        if(!event.getAuthor().getName().equalsIgnoreCase(originalUser.getName()))
            return;

        if(start && messageSent.contains("/") && trig != null || start && messageSent.contains("1") && trig != null ||
                start && messageSent.contains("0") && trig != null || start && messageSent.contains("und") && trig != null
                || start && messageSent.contains("sqrt") && trig != null)
        {
            if(trig.equalsIgnoreCase("sin"))
            {
                if(rad.get(randForCalc) == Math.PI / 3) {
                    answerIsRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI / 6) {
                    answerIsHalf(messageSent, event);
                } else if(rad.get(randForCalc) == 0) {
                    answerIsZero(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI / 2) {
                    answerIsOne(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI / 4) {
                    answerIsRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (2 * Math.PI) / 3) {
                    answerIsRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == (3 * Math.PI) / 4) {
                    answerIsRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (5 * Math.PI) / 6) {
                    answerIsHalf(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI) {
                    answerIsZero(messageSent, event);
                } else if(rad.get(randForCalc) == (7 * Math.PI) / 6) {
                    answerIsNegHalf(messageSent, event);
                } else if(rad.get(randForCalc) == (5 * Math.PI) / 4) {
                    answerIsNegRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (4 * Math.PI) / 3) {
                    answerIsNegRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == (3 * Math.PI) / 2) {
                    answerIsNegOne(messageSent, event);
                } else if(rad.get(randForCalc) == (5 * Math.PI) / 3) {
                    answerIsNegRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == (7 * Math.PI) / 4) {
                    answerIsNegRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (11 * Math.PI) / 6) {
                    answerIsNegHalf(messageSent, event);
                }

                start = false;
            } else if(trig.equalsIgnoreCase("cos"))
            {
                if(rad.get(randForCalc) == Math.PI / 3) {
                    answerIsHalf(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI / 6) {
                    answerIsRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == 0) {
                    answerIsOne(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI / 2) {
                    answerIsZero(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI / 4) {
                    answerIsRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (2 * Math.PI) / 3) {
                    answerIsNegHalf(messageSent, event);
                } else if(rad.get(randForCalc) == (3 * Math.PI) / 4) {
                    answerIsNegRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (5 * Math.PI) / 6) {
                    answerIsNegRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == Math.PI) {
                    answerIsNegOne(messageSent, event);
                } else if(rad.get(randForCalc) == (7 * Math.PI) / 6) {
                    answerIsNegRoot3(messageSent, event);
                } else if(rad.get(randForCalc) == (5 * Math.PI) / 4) {
                    answerIsNegRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (4 * Math.PI) / 3) {
                    answerIsNegHalf(messageSent, event);
                } else if(rad.get(randForCalc) == (3 * Math.PI) / 2) {
                    answerIsZero(messageSent, event);
                } else if(rad.get(randForCalc) == (5 * Math.PI) / 3) {
                    answerIsHalf(messageSent, event);
                } else if(rad.get(randForCalc) == (7 * Math.PI) / 4) {
                    answerIsRoot2(messageSent, event);
                } else if(rad.get(randForCalc) == (11 * Math.PI) / 6) {
                    answerIsRoot3(messageSent, event);
                }

                start = false;
            } else {
                answerIsTangent(messageSent, event);
                start = false;
            }
        }
    }

    public static void play() {
        start = true;

        Random random = new Random();
        int rand = random.nextInt(3);

        rad = new ArrayList<>();

        rad.add(Math.PI / 3);
        rad.add(Math.PI / 6);
        rad.add(0.0);
        rad.add(Math.PI / 2);
        rad.add(Math.PI / 4);
        rad.add((2 * Math.PI) / 3);
        rad.add(( 3 * Math.PI) / 4);
        rad.add((5 * Math.PI ) / 6);
        rad.add(Math.PI);
        rad.add((7 * Math.PI) / 6);
        rad.add((5 * Math.PI) / 4);
        rad.add((4 * Math.PI) / 3);
        rad.add((3 * Math.PI) / 2);
        rad.add((5 * Math.PI) / 3);
        rad.add((7 * Math.PI) /4);
        rad.add((11 * Math.PI) / 6);

        randForCalc = random.nextInt(rad.size());

        if (rand == 1) {
            trig = "sin";
        } else if (rand == 2) {
            trig = "cos";
        } else {
            trig = "tan";
        }
    }

    private void answerIsHalf(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("1/2"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was 1/2. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsNegHalf(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("-1/2"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was -1/2. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsRoot2(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("sqrt2/2"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was sqrt2/2. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsNegRoot2(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("-sqrt2/2"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was -sqrt2/2. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsRoot3(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("sqrt3/2"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was sqrt3/2. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsNegRoot3(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("-sqrt3/2"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was -sqrt3/2. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }


    private void answerIsTangent(String messageSent, MessageReceivedEvent event) {
        if(rad.get(randForCalc) == Math.PI / 3) {
            answerIsSquareRoot3(messageSent, event);
        } else if(rad.get(randForCalc) == Math.PI / 6) {
            answerIsSquareRoot3over3(messageSent, event);
        } else if(rad.get(randForCalc) == 0) {
            answerIsZero(messageSent, event);
        } else if(rad.get(randForCalc) == Math.PI / 2) {
            answerIsUnd(messageSent, event);
        } else if(rad.get(randForCalc) == Math.PI / 4) {
            answerIsOne(messageSent, event);
        } else if(rad.get(randForCalc) == (2 * Math.PI) / 3) {
            answerIsNegSquareRoot3(messageSent, event);
        } else if(rad.get(randForCalc) == (3 * Math.PI) / 4) {
            answerIsNegOne(messageSent, event);
        } else if(rad.get(randForCalc) == (5 * Math.PI) / 6) {
            answerIsNegSquareRoot3over3(messageSent, event);
        } else if(rad.get(randForCalc) == Math.PI) {
            answerIsZero(messageSent, event);
        } else if(rad.get(randForCalc) == (7 * Math.PI) / 6) {
            answerIsSquareRoot3over3(messageSent, event);
        } else if(rad.get(randForCalc) == (5 * Math.PI) / 4) {
            answerIsOne(messageSent, event);
        } else if(rad.get(randForCalc) == (4 * Math.PI) / 3) {
            answerIsSquareRoot3(messageSent, event);
        } else if(rad.get(randForCalc) == (3 * Math.PI) / 2) {
            answerIsUnd(messageSent, event);
        } else if(rad.get(randForCalc) == (5 * Math.PI) / 3) {
            answerIsNegSquareRoot3(messageSent, event);
        } else if(rad.get(randForCalc) == (7 * Math.PI) / 4) {
            answerIsNegOne(messageSent, event);
        } else if(rad.get(randForCalc) == (11 * Math.PI) / 6) {
            answerIsNegSquareRoot3over3(messageSent, event);
        }
    }

    private void answerIsSquareRoot3(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("sqrt3"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was sqrt3. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }
    private void answerIsNegSquareRoot3(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("-sqrt3"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was -sqrt3. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsOne(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("1"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);

            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was 1. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsNegOne(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("-1"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was -1. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsZero(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("0"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was 0. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsUnd(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("und") || messageSent.equalsIgnoreCase("undefined"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was undefined or und. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsSquareRoot3over3(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("sqrt3/3"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was sqrt3/3. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

    private void answerIsNegSquareRoot3over3(String messageSent, MessageReceivedEvent event) {
        if(messageSent.equalsIgnoreCase("-sqrt3/3"))
        {
            event.getChannel().sendMessage("Good job!!! Would you like to play again?").queue(
                    message -> {
                        message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                        message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
                    });

            correct.put(originalUser, correct.get(originalUser) + 1);
            total++;
        } else {
            event.getChannel().sendMessage("Damnnn... The answer was -sqrt3/3. Would you like to play again?").queue(message -> {
                message.addReaction(Emoji.fromUnicode("U+1F1FE")).queue();
                message.addReaction(Emoji.fromUnicode("U+1F1F3")).queue();
            });

            total++;
        }

        trig = null;
    }

}
