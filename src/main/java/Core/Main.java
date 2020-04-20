package Core;

import Commands.Run.CommandHandler;
import Commands.Run.CommandListener;
import Commands.rRank;
import Listeners.AddEnv;
import Sets.Config;
import Sets.CounterEnv;
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

        builder = new JDABuilder(AccountType.BOT);

        //Important
        builder.setToken(Config.TOKEN);

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing(Config.PREFIX + "rank"));

        builder.addEventListener(new AddEnv());
        builder.addEventListener(new CommandListener());

        Commands();

        JDA jda = builder.build();
    }

    public static void Commands() {
        CommandHandler.commands.put("rank", new rRank());
    }
}