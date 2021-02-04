package test;


import aplikacja.projekt.Model.Person;
import aplikacja.projekt.Service.FriendshipService;
import aplikacja.projekt.Service.PersonService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FriendshipServiceTest {

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private PersonService personService;

    @Test
    void shouldCreateFriendship(){
        friendshipService.deleteAll();
        personService.deleteAll();
        Person userOne = new Person("Tom");
        Person userTwo = new Person("TomTwo");

        personService.createPerson(userOne);
        personService.createPerson(userTwo);

        friendshipService.addFriendshipBetweenIDs(userOne.getID(), userTwo.getID());
        Assert.assertNotNull(friendshipService.findIfFriendshipExistsForIDs(userOne.getID(), userTwo.getID()));

    }

    @Test
    void shouldDeleteFriendship(){
        friendshipService.deleteAll();


    }

}
