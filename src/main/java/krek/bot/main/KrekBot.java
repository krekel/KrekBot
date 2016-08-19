package krek.bot.main;

import krek.bot.command.CommandHandler;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

public class KrekBot {

	public static IDiscordClient client;

	public static void main(String[] args) throws DiscordException  {
		client = getClient("Token");
		client.getDispatcher().registerListener(new ReadyListener());
		client.getDispatcher().registerListener(new CommandHandler());
	}

	private static IDiscordClient getClient(String token) {
		try {
			client = new ClientBuilder().withToken(token).login();
		} catch (DiscordException e){
			System.out.println("Error while logging in.");
			e.printStackTrace();
		}
		return client;
	}
	
	public static IDiscordClient getClient(){
		return client;
	}
}
