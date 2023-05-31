package books;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BookListener {
    @JmsListener(destination = "BookQueue")
    public void receiveMessage(final String contactAsString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Books books = objectMapper.readValue(contactAsString, Books.class);
            System.out.println("JMS receiver received message:" + books);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
