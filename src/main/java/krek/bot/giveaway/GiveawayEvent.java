package krek.bot.giveaway;

import java.util.LinkedList;
import java.util.Random;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class GiveawayEvent{

	private boolean status;
	private LinkedList<IUser> participants = new LinkedList<IUser>();
	
	public GiveawayEvent(){ }
	
	public GiveawayEvent(boolean status){

		this.status = status;
	}
	
	public void setStatus(boolean status){

		this.status = status;
	}
	
	public boolean getStatus(){

		return status;
	}

	public boolean isActive(){
		if(getStatus())
			return true;
		return false;
	}
	
	public void addParticipant(IUser participant){

		participants.add(participant);
	}
	
	public IUser getWinner(){
		IUser winner;
		Random rand = new Random();
		winner = participants.get(rand.nextInt(participants.size()));
		
		return winner;
	}
	
	public void endGiveaway(){
		this.status = false;
		participants.clear();
	}
	
}
