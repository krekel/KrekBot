package krek.bot.main;

import krek.bot.games.Coin;
import krek.bot.games.Dice;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.MessageSendEvent;
import sx.blah.discord.handle.impl.events.ReadyEvent;

import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.*;



public class actionListener {

    private MessageBuilder reply = new MessageBuilder(KrekBot.client);
    public static MessageList msg;

	@EventSubscriber
	public void onReady(ReadyEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
		System.out.println("KrekBot is ready!");
		KrekBot.client.changeStatus(Status.game("BotLife"));

	}


    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event)  {
        msg = new MessageList(KrekBot.getClient(), event.getMessage().getChannel(), 50);
        msg.add(event.getMessage());

    }

    @EventSubscriber
    public void onMessageSent(MessageSendEvent event){
        msg = new MessageList(KrekBot.getClient(), event.getMessage().getChannel(), 50);
        msg.add(event.getMessage());

    }


    @EventSubscriber
    public void onDiceEvent(Dice event) throws InterruptedException, RateLimitException, DiscordException, MissingPermissionsException {
            System.out.println("Test.");
            event.roll();
            reply.withChannel(event.getChannel()).withContent("Rolling a six sided dice...").build();
            Thread.sleep(2000);
            reply.withChannel(event.getChannel()).withContent("A " + event.getValue() + " rolled!").build();
    }

    @EventSubscriber
    public void onCoinFlipEvent(Coin event) throws InterruptedException, RateLimitException, DiscordException, MissingPermissionsException {
        event.flip();
        reply.withChannel(event.getChannel()).withContent("A coin has been tossed...").build();
        Thread.sleep(2000);
        reply.withChannel(event.getChannel()).withContent("Result: " + event.getSideUp()).build();
    }


    //////
	
}
