package krek.bot.command;


import krek.bot.main.KrekBot;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class CommandHandler{


    private MessageBuilder reply = new MessageBuilder(KrekBot.client);

    @EventSubscriber
	public void handleCommands(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

        IMessage message = event.getMessage();
        String content = message.getContent().toLowerCase();

        if (content.equals("!hello"))
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + ", Hello!").build();

        else if(content.equals("!help")){
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + " Commands").build();
            reply.withChannel(message.getChannel()).withContent("`" + CommandEvent.getCommandList() + "`").build();

        }
        else if(content.equals("!daniel"))
            reply.withChannel(message.getChannel()).withContent("Damn Daniel!").build();

        else if(content.equals("!fernan"))
            reply.withChannel(message.getChannel()).withContent("Ricky!").build();

        else if(content.equals("!wiso"))
            reply.withChannel(message.getChannel()).withContent("The real G!").build();

        else if(content.equals("!role"))
            reply.withChannel(message.getChannel()).withContent(message.getAuthor() + "'s role(s) " + message.getAuthor().getRolesForGuild(message.getGuild())).build();

//        else if(content.equals("!win") && giveaway.isActive())
//            giveaway.addParticipant(message.getAuthor());

    }









}
