import Sets.Config;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException {

        builder = new JDABuilder(AccountType.BOT);

        //Important
        builder.setToken("");

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("BETA | " + (Config.PREFIX) + "help"));

        Commands();

        JDA jda = builder.build();
    }

    public static void Commands() {

    }
}