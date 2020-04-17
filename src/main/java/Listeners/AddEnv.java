package Listeners;

import Sets.CounterEnv;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class AddEnv extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getAuthor().isBot()) {
            //DO NOTHING
        }else {
            Random r = new Random();
            int y = r.nextInt(250) + 1;

            if (y > 100) {
                int cash;
                int cashNew;
                int multiplier;
                int addCoin = 10;
                if (CounterEnv.propExist("xp" + event.getAuthor().getId())) {
                    cash = Integer.parseInt(CounterEnv.getValue("xp" + event.getAuthor().getId()));
                        multiplier = 1;


                    cashNew = cash + (addCoin * multiplier);

                    CounterEnv.addKey("xp" + event.getAuthor().getId(), String.valueOf(cashNew));
                } else {
                    CounterEnv.addKey("xp" + event.getAuthor().getId(), "50");
                }
            }
        }

    }

}
