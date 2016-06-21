package command;

import chatgame.ChatGameQueue;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

/**
 * Created by Tre on 6/20/2016.
 */
public class SkipCommand implements ChatSystemCommand {

    @Override
    public void run(Player player, String[] args) {

        ChatGameQueue.startRandomGame();

        ChatHelper.sendDarkBlueMessage(player,
                "Skipped the current chat game.");

    }

}
