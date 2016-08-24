package krek.bot.games;

import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.obj.IChannel;

/**
 * Created by Krekel on 8/22/2016.
 */
public class Coin extends Event{

    private IChannel channel;
    private int side = 2;
    private String sideUp;

    public Coin(IChannel channel){
        this.channel = channel;
        flip();
    }

    public IChannel getChannel(){
        return channel;
    }

    public String getSideUp(){
        return sideUp;
    }

    public void flip(){
        if((int)Math.floor(Math.random()* 2) == 1)
            sideUp = "Heads";
        else
            sideUp = "Tails";
    }
}
