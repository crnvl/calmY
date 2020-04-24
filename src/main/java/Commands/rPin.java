package Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class rPin implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length >= 1) {
            event.getGuild().getTextChannelById(event.getTextChannel().getId()).pinMessageById(args[0]).queue();
        }else {
            event.getTextChannel().sendMessage("Please enter a valid Message ID!").queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
