package Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class rEmote implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length >= 1 && event.getMessage().getEmotes().size() >= 1)
        {
            event.getTextChannel().sendMessage(event.getMessage().getEmotes().get(0).getImageUrl()).queue();
        }else
        {
            event.getTextChannel().sendMessage("Please include an Emote!").queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
