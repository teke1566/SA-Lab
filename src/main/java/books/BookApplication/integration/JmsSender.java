package books.BookApplication.integration;

import books.BookApplication.domain.Books;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;
public void sendMessage(Books books){
    try{
        ObjectMapper objectMapper=new ObjectMapper();
        String bookString=objectMapper.writeValueAsString(books);
        System.out.println("sending Jms Message"+bookString);
        jmsTemplate.convertAndSend("BookQueue",bookString);




    }
     catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }

}
public void sendMessageForDelete(String isbn){
    try{
        ObjectMapper objectMapper=new ObjectMapper();
        String deleteBooks=objectMapper.writeValueAsString(isbn);
        System.out.println("Jms sender"+deleteBooks);
        jmsTemplate.convertAndSend("BookQueue",deleteBooks);
    }
    catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }

}


}
