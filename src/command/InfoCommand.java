package command;

import main.Main;
import net.minecraft.server.v1_10_R1.PacketPlayInFlying;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
