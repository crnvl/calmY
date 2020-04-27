package Commands;

import Sets.Config;
import Sets.MetaEnv;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Date;

public class rHelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Date currentTime = new Date();
        long uptime;
        long seconds, minutes, hours, days;

        uptime = currentTime.getTime() - Long.parseLong(MetaEnv.getValue("uptime"));

        seconds = uptime / 1000;
        minutes = seconds / 60; //minutes, seconds
        seconds = seconds % 60;
        hours = minutes / 60; //h, m, s
        minutes = minutes % 60;
        days = hours / 24;
        hours = hours % 60;


        event.getTextChannel().sendMessage(
                new EmbedBuilder()

                        .setColor(Color.PINK)
                        .setTitle("Commands")
                        .addField(Config.PREFIX + "rank", "Shows your current XP, Rank and Level!", false)
                        .addField(Config.PREFIX + "pin <message id>", "Pins a specific Message in the **current** Channel!", false)
                        .addField(Config.PREFIX + "emote <emoji>", "Sends the Link of the specified Emote", false)
                        .addField(Config.PREFIX + "voicetime (--xp)", "Shows your current voicechat time!", false   )
                        .setFooter("Current Uptime: " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.", null)
                        .setThumbnail(event.getJDA().getSelfUser().getAvatarUrl())
                        .build()
        ).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
