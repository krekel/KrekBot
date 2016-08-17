package krek.bot.giveaway;

import java.util.LinkedList;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.obj.IUser;

public class Giveaway {

	private LinkedList<IUser> participants;
	private IUser participant;
	private final String KEY = "!win";
	
	public Giveaway(IUser participant){
		this.participant = participant;
	}
	
	public void setParticipant(IUser participant){
		this.participant = participant;
	}
	
	public IUser getParticipant(){
		return participant;
	}
	
	@EventSubscriber
	public void onGiveawayEvent(GiveawayEvent event){
		participants = new LinkedList<IUser>();
	}
	
	
}
