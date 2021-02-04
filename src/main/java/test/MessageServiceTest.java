package test;

import aplikacja.projekt.Model.Message;
import aplikacja.projekt.Service.MessageService;
import aplikacja.projekt.Service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    void shouldSendMessage(){
        messageService.deleteAll();
    }

    @Test
    void shouldDeleteMessage(){
        messageService.deleteAll();
    }

}
