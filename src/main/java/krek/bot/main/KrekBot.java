package krek.bot.main;

import krek.bot.command.CommandHandler;
import krek.bot.giveaway.GiveawayEvent;
import krek.bot.giveaway.GiveawayHandler;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

public class KrekBot {

	public static IDiscordClient client;

	public static void main(String[] args) throws DiscordException  {
		client = getClient("Token");
		client.getDispatcher().registerListener(new ReadyListener());
		client.getDispatcher().registerListener(new CommandHandler());
        client.getDispatcher().registerListener(new GiveawayHandler());
	}

	private static IDiscordClient getClient(String token) throws DiscordException {
		return new ClientBuilder().withToken(token).login();
	}
	
	public static IDiscordClient getClient(){
		return client;
	}
}
