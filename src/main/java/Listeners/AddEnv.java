package Listeners;

import Sets.CounterEnv;
import Sets.MetaEnv;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Date;
import java.util.Random;

public class AddEnv extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        //REACTION

        if(event.getMessage().getContentRaw().contains("69")){
            event.getMessage().addReaction(event.getJDA().getGuildById("547449487908667402").getEmoteById("701944909812203654")).queue();
        }
        if(event.getMessage().getContentRaw().contains("Walex") || event.getMessage().getContentRaw().contains("walex") || event.getMessage().getContentRaw().contains("WALEX")){
            event.getMessage().addReaction("\uD83D\uDC33").queue();
        }



        //XP

        if(event.getAuthor().isBot() || event.getChannel().getId().contains("697140726664003694") || event.getChannel().getId().contains("465950068990672907")) {

        }else {

            Random r = new Random();
            int y = r.nextInt(Integer.parseInt(MetaEnv.getValue("msgxp"))) + 10;

                int xp, xpNew, multiplier, addXP = y;
                if (CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                    xp = Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId()));
                        multiplier = 1;


                    xpNew = xp + (addXP * multiplier);

                    CounterEnv.addKey("xp" + event.getAuthor().getId(), String.valueOf(xpNew));
                } else {
                    CounterEnv.addKey("xp" + event.getAuthor().getId(), "50");
                }
        }


        //LEVELROLES

        if (event.getAuthor().isBot()) { }else {
            int userLevel;
            int xp = Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId()));
            userLevel = (int) Math.floor((Math.sqrt(2 * xp - 1975)+5)/10);

            try {
                if (CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                    if (userLevel >= 1) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("702162834041339914")).complete();
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
                    if(userLevel >= 30) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("702159351506403348")).complete();
                    }
                    if(userLevel >= 35) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("702159622278086798")).complete();
                    }
                    if(userLevel >= 40) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("702159871570739251")).complete();
                    }
                    if(userLevel >= 69) {
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("701091768996986951")).complete();
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    Date voiceJoin, voiceLeave;
    long voiceTime, voiceXP, addXP;
    long seconds, minutes, hours;

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        voiceJoin = new Date();
        CounterEnv.addKey("vcJ" + event.getMember().getUser().getId(), String.valueOf(voiceJoin.getTime()));
    }

    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        voiceLeave = new Date();

        voiceTime = voiceLeave.getTime() - Long.parseLong(CounterEnv.getValue("vcJ" + event.getMember().getUser().getId()));

        voiceXP = voiceTime / Integer.parseInt(MetaEnv.getValue("voicexp"));

        if (CounterEnv.propExist("xp" + event.getMember().getUser().getId())) {
            addXP = voiceXP + Integer.parseInt(CounterEnv.getValue("xp" + event.getMember().getUser().getId()));
            CounterEnv.addKey("xp" + event.getMember().getUser().getId(), String.valueOf(addXP));
        } else {
            CounterEnv.addKey("xp" + event.getMember().getUser().getId(), String.valueOf(voiceXP));
        }

        seconds = voiceTime / 1000;
        minutes = seconds / 60; //minutes, seconds
        seconds = seconds % 60;
        hours = minutes / 60; //h, m, s
        minutes = minutes % 60;


        if (!event.getMember().getUser().isBot()) {
            event.getMember().getUser().openPrivateChannel().queue(channel -> channel.sendMessage("Your recent Voice Chat Time: ``" + hours + "h " + minutes + "m " + seconds + "s " + "``! A total of ``" + voiceXP + "`` XP has been added to your Account!").queue());
        }
    }
}
