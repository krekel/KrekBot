package krek.bot.command;

import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

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
    private String command;
    private String args;
    private IChannel channel;
    private IUser user;
    private IGuild guild;
    private IMessage message;

    public CommandEvent(String command, String args, IChannel channel, IUser user, IGuild guild, IMessage message){
        this.command = command;
        this.args = args;
        this.channel = channel;
        this.user = user;
        this.guild = guild;
        this.message = message;
    }

    public String getCommand(){
        return command;
    }

    public String getArgs(){
        return args;
    }

    public IChannel getChannel(){
        return channel;
    }

    public IUser getUser(){
        return user;
    }

    public IGuild getGuild(){
        return guild;
    }

    public IMessage getMessage(){
        return message;
    }

    public boolean isCommand(String command){
        return (this.command.equalsIgnoreCase(command));
    }


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
