package Commands;

import Sets.MetaEnv;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class rMeta implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(event.getAuthor().getId().contains("265849018662387712")) {
            if(args.length < 2) {
                event.getChannel().sendMessage("Insufficent Arguments").queue();
            }else {
                switch (args[0]) {
                    case "msgxp":
                        MetaEnv.addKey("msgxp", args[1]);
                        event.getChannel().sendMessage("Successfully changed ``msgxp`` to ``" + args[1] + "``!").queue();
                        break;
                    case "voicexp":
                        MetaEnv.addKey("voicexp", args[1]);
                        event.getChannel().sendMessage("Successfully changed ``voicexp`` to ``" + args[1] + "``!").queue();
                        break;
                    case "removerole":
                        event.getGuild().getController().removeRolesFromMember(event.getGuild().getMemberById(args[1]), event.getGuild().getRoleById(args[2])).queue();
                    case "pin":
                            event.getGuild().getTextChannelById(args[1]).pinMessageById(args[2]).queue();
                        break;

                }
            }
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
