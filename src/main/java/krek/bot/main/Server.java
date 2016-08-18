package krek.bot.main;

import java.security.Permission;
import java.util.EnumSet;
import java.util.List;

import sx.blah.discord.handle.impl.obj.Guild;
import sx.blah.discord.handle.obj.*;

/**
 * Placeholder name
 */
public class Server {

    private static IGuild guildID;

    public Server(IGuild guildID){
        this.guildID = guildID;
    }

    public IGuild getGuildID(){
        return guildID;
    }

    public static boolean isAdmin(IUser user){

        List<IGuild> guilds = KrekBot.getClient().getGuilds();
        IGuild server = null;

        for (int i = 0; i < guilds.size(); i++) {
            if(guilds.get(i).getName().equalsIgnoreCase(guilds.get(i).getName()))
                server = guilds.get(i);
        }

        List<IRole> role = user.getRolesForGuild(server);

        for (int i = 0; i < role.size(); i++)
            if(role.get(i).getPermissions().contains(Permissions.ADMINISTRATOR) || role.get(i).getName().equalsIgnoreCase("Mod"));
                return true;

    }

}
