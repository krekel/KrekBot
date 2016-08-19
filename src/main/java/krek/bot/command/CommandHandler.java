package krek.bot.command;


import krek.bot.main.KrekBot;
import krek.bot.main.Server;
import krek.bot.settings.BotSettings;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class CommandHandler{


    private MessageBuilder reply = new MessageBuilder(KrekBot.client);

    @EventSubscriber
	public void generalCommands(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

        IMessage message = event.getMessage();
        String content = message.getContent().toLowerCase();

        if (content.equals("!hi"))
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + ", Hello!").build();

        else if(content.equals("!help")){
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + " Commands").build();
            reply.withChannel(message.getChannel()).withContent("`" + CommandEvent.getCommandList() + "`").build();

        }
        else if(content.equals("!role"))
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + "'s role(s) " + message.getAuthor().getRolesForGuild(message.getGuild())).build();

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

            }

        }


    } //modCommands()






}
