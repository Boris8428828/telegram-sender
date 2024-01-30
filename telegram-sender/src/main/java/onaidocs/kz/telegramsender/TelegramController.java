package onaidocs.kz.telegramsender;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TelegramController {

    private final TelegramService telegramService;

    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping("/api/v1/admin/telegram/send-message-to-group/")
    public void sendMessageToGroup(@RequestBody TelegramDTO telegramDTO) {
        telegramService.sendMessageToGroup(telegramDTO);
    }
}
