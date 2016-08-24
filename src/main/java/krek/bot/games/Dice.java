package krek.bot.games;

import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.obj.IChannel;

import java.util.Random;

/**
 * Created by Krekel on 8/20/2016.
 */
public class Dice extends Event{

    private final int SIDES = 6;
    private int value;
    private IChannel channel;

    public Dice(IChannel channel){
        this.channel = channel;
        roll();
    }

    public void roll(){
        Random rand = new Random();
        value = rand.nextInt(SIDES) + 1;
    }

    public int getValue(){
        return value;
    }

    public IChannel getChannel(){
        return channel;
    }

}
