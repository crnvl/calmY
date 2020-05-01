package Commands;

import Sets.CounterEnv;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

import static java.lang.Math.round;

public class rRank implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


            int xp, level;
            if(event.getMessage().getMentionedUsers().size() >= 1) {
                if (CounterEnv.propExist("xp" + event.getMessage().getMentionedUsers().get(0).getId())) {
                    xp = Integer.parseInt(CounterEnv.getValue("xp" + event.getMessage().getMentionedUsers().get(0).getId()));
                } else {
                    xp = 0;
                }

                double userLevel;
                double userNextLevelPercentage;
                float USERXPINPUT = xp;

                //formula:    (Math.sqrt(2 * USERXPINPUT - 1975)+5)/10

                userLevel = round((Math.sqrt(2 * USERXPINPUT - 1975) + 5) / 10);
                userNextLevelPercentage = (Math.sqrt(2 * USERXPINPUT - 1975) + 5) / 10 - Math.floor((Math.sqrt(2 * USERXPINPUT - 1975) + 5) / 10);

                if (Double.isNaN(userLevel)) {
                    userLevel = 0;
                }

                int percent = (int) Math.floor(userNextLevelPercentage * 100);


                //LEADERBOARD
                int ranking = 1;

                for (int j = 0; j < event.getGuild().getMembers().size(); j++) {
                    if (CounterEnv.propExist("xp" + event.getGuild().getMembers().get(j).getUser().getId())) {
                        if (!event.getJDA().getUserById(event.getGuild().getMembers().get(j).getUser().getId()).isBot()) {
                            if (!event.getGuild().getMembers().get(j).getUser().getId().contains(event.getMessage().getMentionedUsers().get(0).getId())) {
                                if (Integer.parseInt(CounterEnv.getValue("xp" + event.getMessage().getMentionedUsers().get(0).getId())) <= Integer.parseInt(CounterEnv.getValue("xp" + event.getGuild().getMembers().get(j).getUser().getId()))) {

                                    ranking++;
                                }
                            }
                        }
                    }
                }


                event.getTextChannel().sendMessage(
                        new EmbedBuilder()
                                .setTitle("XP for " + event.getMessage().getMentionedUsers().get(0).getAsTag() + "!")
                                .setColor(Color.PINK)
                                .addField("Raw XP", "**" + xp + "**", true)
                                .addField("Level", "**" + round(userLevel) + "**", true)
                                .addField("Global Ranking", "**#" + ranking + "**", true)
                                .setFooter("Level Completion: " + percent + "%", null)
                                .setThumbnail(event.getMessage().getMentionedUsers().get(0).getAvatarUrl())
                                .build()
                ).queue();
            }else {
                if(CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                    xp = Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId()));
                }else {
                    xp = 0;
                }

                double userLevel;
                double  userNextLevelPercentage;
                float USERXPINPUT = xp;

                //formula:    (Math.sqrt(2 * USERXPINPUT - 1975)+5)/10

                userLevel = round(Math.sqrt(2 * USERXPINPUT - 1975)+5)/10;
                userNextLevelPercentage = (Math.sqrt(2 * USERXPINPUT - 1975)+5)/10 - Math.floor((Math.sqrt(2 * USERXPINPUT - 1975)+5)/10);

                if(Double.isNaN(userLevel)) {
                    userLevel = 0;
                }

                int percent = (int) Math.floor(userNextLevelPercentage * 100);


                //LEADERBOARD
                int ranking = 1;

                    for (int j = 0; j < event.getGuild().getMembers().size(); j++)
                    {
                        if(CounterEnv.propExist("xp" + event.getGuild().getMembers().get(j).getUser().getId()))
                        {
                            if(!event.getJDA().getUserById(event.getGuild().getMembers().get(j).getUser().getId()).isBot())
                            {
                                if (!event.getGuild().getMembers().get(j).getUser().getId().contains(event.getAuthor().getId()))
                                {
                                    if (Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId())) <= Integer.parseInt(CounterEnv.getValue("xp" + event.getGuild().getMembers().get(j).getUser().getId())))
                                    {

                                        ranking++;
                                    }
                                }
                            }
                        }
                    }


                event.getTextChannel().sendMessage(
                        new EmbedBuilder()
                                .setTitle("Your current XP, " + event.getAuthor().getAsTag() + "!")
                                .setColor(Color.PINK)
                                .addField("Raw XP", "**" + xp + "**", true)
                                .addField("Level", "**" + round(userLevel) + "**", true)
                                .addField("Global Ranking", "**#" + ranking + "**", true)
                                .setFooter("Level Completion: " + percent + "%", null)
                                .setThumbnail(event.getAuthor().getAvatarUrl())
                                .build()
                ).queue();
            }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

}
