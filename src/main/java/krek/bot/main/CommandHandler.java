package krek.bot.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.impl.client.EntityEnclosingRequestWrapper;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
;

public class CommandHandler{ 

	private String[] generalCommandList = {"!hi", "!daniel", "!fernan", "!wiso", "!role", "!help", "!weather"};
	
	private final static String KEY = "!";
	private MessageBuilder reply = new MessageBuilder(KrekBot.client);
	GiveawayEvent giveaway;

	//General Chat commands
	@EventSubscriber
	public void generalChat(MessageReceivedEvent event)   {

		try {

			IMessage message = event.getMessage();
			String content  = message.getContent().toLowerCase();

			if(content.startsWith(KEY)){
				
				if(content.equals("!hi"))
					reply.withChannel(message.getChannel()).withContent(message.getAuthor() + ", Hello!").build();
				
				else if(content.equals("!help")){
					reply.withChannel(message.getChannel()).withContent(message.getAuthor() + " Commands").build();
					reply.withChannel(message.getChannel()).withContent("`" + generalCommands() + "`").build();
					
				}
					
				else if(content.equals("!daniel"))
					reply.withChannel(message.getChannel()).withContent("Damn Daniel!").build();
				
				else if(content.equals("!fernan"))	
					reply.withChannel(message.getChannel()).withContent("Ricky!").build();
				
				else if(content.equals("!wiso"))
					reply.withChannel(message.getChannel()).withContent("The real G!").build();
				
				else if(content.equals("!role"))
					reply.withChannel(message.getChannel()).withContent(message.getAuthor() + "'s role(s) ").build();
				
				else if(content.equals("!win") && giveaway.getStatus() == true)
					giveaway.addParticipant(message.getAuthor());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	} //generalChat()
	
	@EventSubscriber
	public void adminCommands(MessageReceivedEvent event){
		try{
			
			IUser user = event.getMessage().getAuthor();
			IMessage message = event.getMessage();
			String content  = message.getContent().toLowerCase();
			
			
			if(isAdmin(user)){
				
				if(content.equals("!admin"))
					reply.withChannel(message.getChannel()).withContent(message.getAuthor() + ", is an admin!").build();
				
				else if(content.equals("!botname"))
					BotSettings.changeBotName(KrekBot.client, stringHandler(content));
				
				else if(content.equals("!status"))
					BotSettings.changeBotStatus(KrekBot.client, Status.game(stringHandler(content)));
				
				else if(content.equals("!startraffle")){
					giveaway = new GiveawayEvent(true);
					reply.withChannel(message.getChannel()).withContent("Type !win to enter the giveway!").build();
				}
				else if(content.equals("!endraffle") && giveaway.getStatus() == true){
					reply.withChannel(message.getChannel()).withContent("Winner of the giveway: " + giveaway.getWinner().getName()).build();
					giveaway.endGiveaway();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	} //adminCommands
	
	private boolean isAdmin(IUser user){
		
		List<IGuild> guilds = KrekBot.getClient().getGuilds();
		IGuild server = null;
		
		for(int i = 0; i < guilds.size(); i++)
			if(guilds.get(i).getName().equalsIgnoreCase(guilds.get(i).getName()))
				server = guilds.get(i);
		
		List<IRole> roles = user.getRolesForGuild(server);
		
		for(int i = 0; i < roles.size(); i++)
			if(roles.get(i).getName().equalsIgnoreCase("Mamao"))
				return true;
		
		return false;
		
	}
	
	//name - placeholder
	private String stringHandler(String command){
		String[] param = null;
		String output = "";
		
		if(command.isEmpty())
			return command;
		else if(command.substring(0).contains(" ")){
				param = command.substring(0).split(" ");
			for (int i = 1; i < param.length; i++) 
				output += param[i] + " ";
		}
	
			
			return output;
		
	}
	

	private String generalCommands(){
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < generalCommandList.length; i++){ 
			str.append(generalCommandList[i]);
			if(i < generalCommandList.length - 1)
				str.append(", ");
		}
		return str.toString();
	}
	
}
