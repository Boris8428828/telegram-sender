package onaidocs.kz.telegramsender;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TelegramDTO {

    String name;

    String phone;

    String email;

    String message;

    public String toStringKeyValue() {
        try {
            String encodedMessage = URLEncoder.encode(message, "UTF-8");
            return "<b>Информация запроса: </b>" + "\nФИО: " + name + "\nТелефон: +" + phone + "\nЭлектронный адрес: " + email + "\nСообщение: " + encodedMessage;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
