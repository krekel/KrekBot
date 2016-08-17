package krek.bot.main;

import krek.bot.command.CommandHandler;
import krek.bot.giveaway.GiveawayEvent;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

public class KrekBot {

	public static IDiscordClient client;

	public static void main(String[] args) throws DiscordException  {
		client = getClient("token");
		client.getDispatcher().registerListener(new ReadyListener());
		client.getDispatcher().registerListener(new CommandHandler());
		client.getDispatcher().registerListener(new GiveawayEvent());
	}

	public static IDiscordClient getClient(String token) throws DiscordException {
		return new ClientBuilder().withToken(token).login();
	}
	
	public static IDiscordClient getClient(){
		return client;
	}
}
