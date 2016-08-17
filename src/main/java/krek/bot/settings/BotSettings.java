package krek.bot.settings;

import java.util.Optional;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.HTTP429Exception;
import sx.blah.discord.util.RateLimitException;

public class BotSettings {

	public static void changeBotStatus(IDiscordClient client, Status botStatus){
		client.changeStatus(botStatus);
	}
	
	
	
	public static void changeBotName(IDiscordClient client, String name) throws DiscordException, RateLimitException{
		client.changeUsername(name);
	}
	
	
}
