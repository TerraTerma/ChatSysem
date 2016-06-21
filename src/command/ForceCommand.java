package command;

import chatgame.ChatGameQueue;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

/**
 * Created by Tre on 6/20/2016.
 */
public class ForceCommand implements ChatSystemCommand {

    @Override
    public void run(Player player, String[] args) {

        String gameName;

        if (args.length == 1) gameName = args[0];
        else return;

        if (!ChatGameQueue.forceStartGame(gameName))
            ChatHelper.sendAquaMessage(player, "Couldn't find the game " +
                    gameName + ".");

    }
}
