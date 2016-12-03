package chat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public ChatMessage send(Message message) throws Exception {
		final String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new ChatMessage(message.getFrom(), message.getText(), time);
	}

}
