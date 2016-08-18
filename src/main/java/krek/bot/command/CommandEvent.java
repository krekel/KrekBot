package krek.bot.command;

import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by Krekel on 8/15/2016.
 * Purpose of this class is still unknown.
 * May change.
 */
public class CommandEvent extends Event{

    private final static String[] COMMAND_LIST = {"!hi", "!role", "!help", "!weather", "!status <bot status>", "!botname <name>", "!startraffle", "!endraffle"};


    public static String getCommandList(){
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < COMMAND_LIST.length; i++){
            str.append(COMMAND_LIST[i]);
            if(i < COMMAND_LIST.length - 1)
                str.append(", ");
        }
        return str.toString();
    }
}
