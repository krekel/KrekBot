package krek.bot.main;

import krek.bot.command.CommandHandler;
import org.ini4j.Wini;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

import java.io.File;
import java.io.IOException;

public class KrekBot {

	public static IDiscordClient client;
    private static String TOKEN;


	public static void main(String[] args) {
        getToken();
		client = getClient();
		client.getDispatcher().registerListener(new actionListener());
		client.getDispatcher().registerListener(new CommandHandler());
	}

	private static void login(String token) {
		try {
			client = new ClientBuilder().withToken(token).login();
		} catch (DiscordException e){
			System.out.println("Error while logging in.");
			e.printStackTrace();
		}
	}
	
	public static IDiscordClient getClient(){

        return client;
	}

    private static void getToken(){
        try {
            Wini ini = new Wini(new File("C:\\Users\\Krekel\\workspace\\KrekBot\\BotSettings.ini"));
            TOKEN = ini.get("Credentials", "Token");
			login(TOKEN);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
