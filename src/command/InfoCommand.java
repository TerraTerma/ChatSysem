package command;

import main.Main;
import org.bukkit.command.CommandSender;
import utilities.ChatHelper;

public class InfoCommand extends ChatSystemCommand {

    private Main main;

    public InfoCommand (Main main) {
        super ("csinfo");
        this.main = main;
    }

    @Override
    boolean run(CommandSender sender, Object... args) {

        String name = main.getName();
        String version = main.getDescription().getVersion();

        ChatHelper.sendYellowMessage(sender, name + " " + version);

//        Player player = (Player) sender;

//        /*
//        For testing packets
//         */
//        for (Field field : PacketPlayInFlying.class.getFields()) {
//            player.sendMessage("Field: " + field.getName());
//        }
//
//        for (Method method : PacketPlayInFlying.class.getMethods()) {
//            player.sendMessage("Method: " + method.getName());
//        }

        return true;
    }
}
