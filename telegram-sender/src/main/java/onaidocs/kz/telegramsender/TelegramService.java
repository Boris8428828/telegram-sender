package onaidocs.kz.telegramsender;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TelegramService {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.group.chatId}")
    private String groupChatId;


    public void sendMessageToGroup(TelegramDTO telegramDTO) {
        String apiUrl = String.format("https://api.telegram.org/bot%s/sendMessage", botToken);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String message = telegramDTO.toStringKeyValue();

        String url = apiUrl + "?chat_id=" + groupChatId + "&text=" + message + "&parse_mode=HTML";

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url, entity, String.class);
    }
}

