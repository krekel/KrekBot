package krek.bot.command;

import sx.blah.discord.api.events.Event;

/**
 * Created by Krekel on 8/15/2016.
 * Purpose of this class is still unknown.
 * Class name is not final by any means.
 * May change.
 */

//TODO Change name of this class

public class CommandEvent extends Event{

    private final static String[] COMMAND_LIST = {"!hi", "!role", "!help", "!info", "!weather",
                                                                            "!roll", "!flip", "!status <bot status>",
                                                                            "!botname <name>", "!startraffle", "!endraffle"};

    public static String getCommandList(){
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < COMMAND_LIST.length; i++){
            str.append(COMMAND_LIST[i]);
            if(i < COMMAND_LIST.length - 1)
                str.append(", ");
        }
        return str.toString();
    }

    public static String getInfo(){

        return "```" + "KrekBot is a SIMPLE Discord bot created by " + "\n" +
                "Luis G. Diaz(Krekel) as one of his first programming projects." + "\n" +
                "If you want to help me in any way feel free to contact me." + "```" +
                "https://github.com/krekel/KrekBot";
    }

}
