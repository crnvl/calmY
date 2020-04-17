package Commands;

import Sets.CounterEnv;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class rRank implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        String balance;
        if(event.getMessage().getMentionedUsers().size() >= 1) {
            if(CounterEnv.propExist("xp" + event.getMessage().getMentionedUsers().get(0).getId())) {
                balance = CounterEnv.getValue("xp" + event.getMessage().getMentionedUsers().get(0).getId());
            }else {
                balance = "0";
            }

            event.getTextChannel().sendMessage(
                    new EmbedBuilder()
                            .setTitle("XP for " + event.getMessage().getMentionedUsers().get(0).getAsTag() + "!")
                            .setColor(Color.PINK)
                            .addField("Raw XP", "**" + balance + "**", true)
                            .build()
            ).queue();
        }else {
            if(CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                balance = CounterEnv.getValue("xp" + event.getAuthor().getId());
            }else {
                balance = "0";
            }

            event.getTextChannel().sendMessage(
                    new EmbedBuilder()
                            .setTitle("Your current XP, " + event.getAuthor().getAsTag() + "!")
                            .setColor(Color.PINK)
                            .addField("Raw XP", "**" + balance + "**", true)
                            .build()
            ).queue();
        }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

}
