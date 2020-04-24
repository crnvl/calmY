package Commands;

import Sets.Config;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class rHelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new EmbedBuilder()

                        .setColor(Color.PINK)
                        .setTitle("Commands")
                        .addField(Config.PREFIX + "rank", "Shows your current XP, Rank and Level!", false)
                        .addField(Config.PREFIX + "pin <message id>", "Pins a specific Message in the **current** Channel!", false)
                        .build()
        ).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
