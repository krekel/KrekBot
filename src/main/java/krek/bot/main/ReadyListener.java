package krek.bot.main;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.MessageBuilder;

public class ReadyListener implements IListener<ReadyEvent> {

	public void handle(ReadyEvent event) {
		System.out.println("KrekBot is ready!");
		KrekBot.client.changeStatus(Status.game("BotLife"));
	}
	
	
}
