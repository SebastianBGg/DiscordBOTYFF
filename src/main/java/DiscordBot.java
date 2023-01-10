import events.Messagelisteners;
import events.Readyevent;
import events.TalkingEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("TOKEN")
                .addEventListeners(new Readyevent(), new Messagelisteners(), new TalkingEvent())
                .build();
        ListenerAdapter listener = new TalkingEvent.SpeakerDetector();
        jda.addEventListener(listener);
    }
}
