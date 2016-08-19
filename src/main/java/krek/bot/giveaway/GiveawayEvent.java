package krek.bot.giveaway;

import java.util.LinkedList;
import java.util.Random;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

public class GiveawayEvent{

	private boolean status;
	private LinkedList<IUser> participants = new LinkedList<IUser>();
    private int numOfParticipants = 0;
	
	public GiveawayEvent(boolean status){

		this.status = status;
	}
	
	public void setStatus(boolean status){

		this.status = status;
	}

    public int getNumOfParticipants(){
        return numOfParticipants;
    }
	
	public boolean getStatus(){

		return status;
	}

	public boolean isActive(){
       return (this.status);
    }
	
	public void addParticipant(IUser participant){

        if(!isParticipating(participant)) {
            participants.add(participant);
            numOfParticipants++;
        }
	}
	
	public IUser getWinner(){
		IUser winner;
		Random rand = new Random();
		winner = participants.get(rand.nextInt(participants.size()));
		
		return winner;
	}
	
	public void endGiveaway(){
		this.status = false;
	}

	 // Allows one entry per User
    private boolean isParticipating(IUser user){
        for (IUser participant : participants)
            if (participant.equals(user))
                return true;
        return false;
    }

}
