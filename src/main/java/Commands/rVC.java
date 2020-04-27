package Commands;

import Sets.CounterEnv;
import Sets.MetaEnv;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Date;

public class rVC implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Date  currentTime;
        long voiceTime, voiceXP;
        long seconds, minutes, hours;

        currentTime = new Date();

        voiceTime = currentTime.getTime() - Long.parseLong(CounterEnv.getValue("vcJ" + event.getMember().getUser().getId()));

        seconds = voiceTime / 1000;
        minutes = seconds / 60; //minutes, seconds
        seconds = seconds % 60;
        hours = minutes / 60; //h, m, s
        minutes = minutes % 60;

        if(event.getMember().getVoiceState().inVoiceChannel())
        {
            if(args.length >= 1 && args[0].contains("--xp"))
            {

                voiceXP = voiceTime / Integer.parseInt(MetaEnv.getValue("voicexp"));

                event.getTextChannel().sendMessage(event.getMember().getUser().getAsMention() + ", you're in a voicechat for " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds!\n" +
                        "This would make a total of " + voiceXP + " XP!").queue();
            }else {
                event.getTextChannel().sendMessage(event.getMember().getUser().getAsMention() + ", you're in a voicechat for " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds!").queue();
            }
        }else {
            event.getTextChannel().sendMessage("You need to join a voicechat for this!").queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
