package Listeners;

import Sets.CounterEnv;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class AddEnv extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        event.getChannel().sendTyping().queue();

        if(event.getMessage().getContentRaw().contains("69")){
            event.getMessage().addReaction(event.getJDA().getGuildById("547449487908667402").getEmoteById("701944909812203654")).queue();
        }

        if(event.getAuthor().isBot() || event.getChannel().getId().contains("697140726664003694") || event.getChannel().getId().contains("465950068990672907")) {

            //DO NOTHING
        }else {
            Random r = new Random();
            int y = r.nextInt(250) + 1;

            if (y > 100) {
                int xp, xpNew, multiplier, addXP = 10;
                if (CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                    xp = Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId()));
                        multiplier = 1;


                    xpNew = xp + (addXP * multiplier);

                    CounterEnv.addKey("xp" + event.getAuthor().getId(), String.valueOf(xpNew));
                } else {
                    CounterEnv.addKey("xp" + event.getAuthor().getId(), "50");
                }
            }
        }


        if (event.getAuthor().isBot()) {

        }else {
            int userLevel;
            int xp = Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId()));
            userLevel = (int) Math.floor((Math.sqrt(2 * xp - 1975)+5)/10);
            System.out.println(userLevel);

            try {
                if (CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                    if (userLevel == 1) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("700716789012627598")).complete();
                    }
                    if (userLevel >= 5) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("700717817170886676")).complete();
                    }
                    if (userLevel >= 10) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("700717573104205956")).complete();
                    }
                    if (userLevel >= 15) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("700717918052417597")).complete();
                    }
                    if (userLevel >= 20) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("700718336610140171")).complete();
                    }
                    if (userLevel >= 25) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("700718653263315027")).complete();
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
