package listeners;

import core.Settings;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if(msg.getContentRaw().startsWith(Settings.PREFIX)) {
            String[] command = msg.getContentRaw().replace(Settings.PREFIX, "").split(" ");
            switch (command[0]) {
                case "test" -> {
                    msg.getChannel().sendMessage(
                            new EmbedBuilder()
                                    .setTitle("Test Command")
                                    .setDescription("Discord API Ping is **" + msg.getJDA().getGatewayPing() + "** ms.")
                                    .build()
                    ).queue();
                }
                default -> {
                    msg.getChannel().sendMessage("`This command doesn't exist.`").queue();
                }
            }
        }
    }
}
