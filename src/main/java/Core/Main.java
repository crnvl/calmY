package Core;

import Commands.*;
import Commands.Run.CommandHandler;
import Commands.Run.CommandListener;
import Listeners.AddEnv;
import Listeners.Startup;
import Sets.Config;
import Sets.CounterEnv;
import Sets.MetaEnv;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException {

        CounterEnv.init();
        MetaEnv.init();
        if (!MetaEnv.propExist("msgxp")) {
            MetaEnv.addKey("msgxp", "25");
        }
        if (!MetaEnv.propExist("voicexp")) {
            MetaEnv.addKey("voicexp", "100");
        }

        builder = new JDABuilder(AccountType.BOT);

        //Important
        builder.setToken(Config.TOKEN);

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.watching("WALEX Inc. | " + Config.PREFIX + "help"));

        builder.addEventListener(new AddEnv());
        builder.addEventListener(new CommandListener());
        builder.addEventListener(new Startup());

        Commands();

        JDA jda = builder.build();
    }

    public static void Commands() {
        CommandHandler.commands.put("rank", new rRank());
        CommandHandler.commands.put("meta", new rMeta());
        CommandHandler.commands.put("pin", new rPin());
        CommandHandler.commands.put("help", new rHelp());
        CommandHandler.commands.put("emote", new rEmote());
        CommandHandler.commands.put("voicetime", new rVC());
        CommandHandler.commands.put("vt", new rVC());
    }
}