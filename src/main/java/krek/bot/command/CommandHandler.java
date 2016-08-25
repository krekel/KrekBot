package krek.bot.command;

import krek.bot.games.Coin;
import krek.bot.games.Dice;
import krek.bot.main.KrekBot;
import krek.bot.main.Server;
import krek.bot.main.actionListener;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.*;

public class CommandHandler {


    private MessageBuilder reply = new MessageBuilder(KrekBot.client);


    //    TODO Handle Exceptions
    @EventSubscriber
    public void generalCommands(CommandEvent event) throws RateLimitException, DiscordException, MissingPermissionsException, InterruptedException {

        if (event.isCommand("!hi"))
            reply.withChannel(event.getChannel()).withContent(event.getUser() + ", Hello!").build();

        if (event.isCommand("!help")) {
            reply.withChannel(event.getChannel()).withContent(event.getUser() + " Commands").build();
            reply.withChannel(event.getChannel()).withContent("```" + CommandEvent.getCommandList() + "```").build();

        } else if (event.isCommand("!role")) {
            reply.withChannel(event.getChannel()).withContent(event.getUser()
                    + "'s role(s) " + event.getUser().getRolesForGuild(event.getGuild())).build();

        } else if (event.isCommand("!info")) {
            reply.withChannel(event.getChannel()).withContent(CommandEvent.getInfo()).build();

        } else if (event.isCommand("!roll")) {
            KrekBot.client.getDispatcher().dispatch(new Dice(event.getChannel()));
            System.out.println("Dice event dispatched.");

        } else if (event.isCommand("!flip")) {
            KrekBot.client.getDispatcher().dispatch(new Coin(event.getChannel()));
            System.out.println("Coin event dispatched.");

        }

    }

    @EventSubscriber
    public void modCommands(CommandEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

        if (Server.isAdmin(event.getUser())) {

            if (event.isCommand("!status"))
                KrekBot.getClient().changeStatus(Status.game(event.getArgs()));

            else if (event.isCommand("!botname"))
                KrekBot.getClient().changeUsername(event.getArgs());

            else if (event.isCommand("!clean")) {
                actionListener.msg.add(event.getMessage());
                actionListener.msg.bulkDelete(actionListener.msg.copy());
            }

        }

    }


}

