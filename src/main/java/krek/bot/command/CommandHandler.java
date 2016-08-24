package krek.bot.command;

import krek.bot.games.Coin;
import krek.bot.games.Dice;
import krek.bot.main.KrekBot;
import krek.bot.main.Server;
import krek.bot.main.actionListener;
import krek.bot.settings.BotSettings;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.*;

public class CommandHandler{


    private MessageBuilder reply = new MessageBuilder(KrekBot.client);


//    TODO Handle Exceptions
    @EventSubscriber
	public void generalCommands(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException, InterruptedException {

        IMessage message = event.getMessage();
        String content = message.getContent().toLowerCase();

        if (content.equals("!hi"))
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + ", Hello!").build();

        else if(content.equals("!help")){
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + " Commands").build();
            reply.withChannel(message.getChannel()).withContent("```" + CommandEvent.getCommandList() + "```").build();

        }
        else if(content.equals("!role"))
            reply.withChannel(message.getChannel()).withContent(message.getAuthor()
                    + "'s role(s) " + message.getAuthor().getRolesForGuild(message.getGuild())).build();

        else if(content.equals("!info"))
            reply.withChannel(message.getChannel()).withContent(CommandEvent.getInfo()).build();

        else if(content.contains("rip") || content.contains("RIP"))
            reply.withChannel(message.getChannel()).withContent(":skull:").build();

        else if(content.equals("!roll")){
            KrekBot.client.getDispatcher().dispatch(new Dice(message.getChannel()));
            System.out.println("Dice event dispatched.");
        } else if(content.equals("!flip")){
            KrekBot.client.getDispatcher().dispatch(new Coin(message.getChannel()));
            System.out.println("Coin flip event dispatched.");
        }



    }

    @EventSubscriber
    public void modCommands(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

        IMessage message = event.getMessage();
        String content = message.getContent();

        if(Server.isAdmin(message.getAuthor())) {

            if (content.startsWith("!status ")) {
                String args = content.substring("!status ".length());
                BotSettings.changeBotStatus(KrekBot.getClient(), Status.game(args));

            } else if (content.startsWith("!botname ")) {
                String args = content.substring("!botname ".length());
                BotSettings.changeBotName(KrekBot.getClient(), args);

            } else if(content.equals("!clean")){
                actionListener.msg.add(message);
                actionListener.msg.bulkDelete(actionListener.msg.copy());
            }

        }


    } //modCommands()






}
