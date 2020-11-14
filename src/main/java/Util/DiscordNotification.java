package Util;

import Discord.DiscordWebhook;

import java.awt.*;
import java.io.IOException;

/**
 * @author Grzegorz Nowakowski
 */
public class DiscordNotification {

    public static void sendDiscordNotification(String krDllRecord, String euDllRecord, String classicDllRecord) throws IOException {


        DiscordWebhook webhook = new DiscordWebhook();


        webhook.setUsername("Aion is Dead");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Version Update")
                .setDescription("New game version detected!")
                .setColor(Color.RED)
                .addField("KR", krDllRecord, true)
                .addField("EU", euDllRecord, true)
                .addField("Classic", classicDllRecord, true)
                .setFooter("Update initiated. Estimated downtime: 5min", "")
                .setUrl("https://aionpowerbook.com/powerbook/Version"));
        webhook.execute(); //Handle exception
    }
}
