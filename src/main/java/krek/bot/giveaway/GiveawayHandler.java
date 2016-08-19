package krek.bot.giveaway;

import java.util.LinkedList;

import krek.bot.main.KrekBot;
import krek.bot.main.Server;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.MessageBuilder;

public class GiveawayHandler {

    private GiveawayEvent giveaway;
    private final String ENTRY = "!win";

    private MessageBuilder reply = new MessageBuilder(KrekBot.client);

    @EventSubscriber
    public void manageGiveaway(MessageReceivedEvent event){
        IMessage message = event.getMessage();
        String content = message.getContent();

        if(Server.isAdmin(message.getAuthor())){
            if(content.equalsIgnoreCase("!startraffle")) {
                reply.withChannel(message.getChannel()).withContent("A Giveaway has started! Type !win to enter.");
                giveaway = new GiveawayEvent(true);

            }
            else if(content.equalsIgnoreCase("!endraffle")) {
                reply.withChannel(message.getChannel()).withContent("The Giveaway has ended!" +
                        "The winner is: " + giveaway.getWinner().getName());
                giveaway.endGiveaway();
                System.out.println(giveaway.getNumOfParticipants());
            }
        }

    }

    public void entry(MessageReceivedEvent event){
        IMessage message = event.getMessage();
        String content = message.getContent();

        if(giveaway.isActive()){
            if(!giveaway.isParticipating(message.getAuthor()))
                if(content.equalsIgnoreCase(ENTRY))
                    giveaway.addParticipant(message.getAuthor());
            else
                reply.withChannel(message.getChannel()).withContent("Only one entry per person.");
        }
    }
	
	
}
