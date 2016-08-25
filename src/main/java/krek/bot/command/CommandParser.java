package krek.bot.command;

import krek.bot.main.KrekBot;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;


/**
 * Created by luis-a7x on 8/24/16.
 */
public class CommandParser {

    private String command;
    private String args = null;
    private final String KEY = "!";

    @EventSubscriber
    public void onCommand(MessageReceivedEvent event){

        IMessage message = event.getMessage();
        String content = message.getContent();

        if(content.startsWith(KEY)){

            if(content.contains(" ")){
                command = content.split(" ")[0];
                args = content.substring(content.indexOf(' ') + 1);
            } else {
                command = content;
                args = null;
            }

            KrekBot.client.getDispatcher().dispatch(new CommandEvent(command, args, message.getChannel(),
                    message.getAuthor(), event.getMessage().getGuild(), message));
        }


    }


}
