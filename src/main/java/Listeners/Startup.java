package Listeners;

import Sets.MetaEnv;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Date;

public class Startup extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Date startup = new Date();
        MetaEnv.addKey("uptime", String.valueOf(startup.getTime()));
    }
}
