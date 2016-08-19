package krek.bot.giveaway;

import java.util.LinkedList;

import krek.bot.main.Server;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class GiveawayHandler {

    private GiveawayEvent giveaway;
    private final String ENTRY = "!win";

    @EventSubscriber
    public void manageGiveaway(MessageReceivedEvent event){
        IMessage message = event.getMessage();
        String content = message.getContent();

        if(Server.isAdmin(message.getAuthor())){
            if(content.equalsIgnoreCase("!startraffle"))
                giveaway = new GiveawayEvent(true);
            else if(content.equalsIgnoreCase("!endraffle"))
                giveaway.endGiveaway();
        }
    }

    public void entry(MessageReceivedEvent event){
        IMessage message = event.getMessage();
        String content = message.getContent();

        if(giveaway.isActive()){
            if(content.equalsIgnoreCase(ENTRY))
                giveaway.addParticipant(message.getAuthor());
        }
    }
	
	
}
