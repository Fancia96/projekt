package aplikacja.projekt.Controller;

import aplikacja.projekt.Model.Friendship;
import aplikacja.projekt.Model.Person;
import aplikacja.projekt.Service.FriendshipService;
import aplikacja.projekt.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private FriendshipService friendshipService;

    @GetMapping("/itsok")
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("itsok :D");

    }

    @PostMapping("/addCustomData")
    public ResponseEntity<String> addCustomData(){
        Person  createThisPerson1 = personService.createPerson(
                new Person("Fancia"));
        Person  createThisPerson2 = personService.createPerson(
                new Person("Fashoo"));
        Person  createThisPerson3 = personService.createPerson(
                new Person("Shobs"));

        //add Fancia Friend Fashoo
        Friendship addFriends1 = friendshipService.createFriendshipByID(
                createThisPerson1.getID(),
                createThisPerson2.getID());

        Friendship  addFriends2 = friendshipService.createFriendshipByID(
                createThisPerson1.getID(),
                createThisPerson3.getID());

//        List<Person>  addFriends3 = personService.addFriend(
//                createThisPerson2,
//                createThisPerson3);
//nie mozna dodac siebie samego
        //messages then

        return ResponseEntity.ok("itsok :D");

    }

    //usuwam osobe ale tez musze zawrzec wiadomosci i przyjaciol ze strony tej osoby
    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id){
        personService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    //tworze ciało i wkleję sobie tutaj ładnie
    @PostMapping("/createPerson")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person  createThisPerson = personService.createPerson(person);

        return ResponseEntity.ok(createThisPerson);
    }

    //czy istnieje , szukam po nicku
    @PostMapping("/addFriend{id}")
    public ResponseEntity<Person> addFriend(@RequestBody Person person){
        Person  createThisPerson = personService.createPerson(person);

        return ResponseEntity.ok(createThisPerson);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updateById(@RequestBody Person player){
        return ResponseEntity.ok(personService.updatePersonById(player));
    }

    @GetMapping("/getAllPerson")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

//    @PutMapping("/players/{id}")
//    public ResponseEntity<Player> update(@RequestBody Player player){
//        return ResponseEntity.ok(playerService.update(player));
//
//    }
//
//
//    @GetMapping("/players/{id}/attack/{otherid}")
//    public ResponseEntity<Player> update(@PathVariable Long id, @PathVariable Long otherid){
//        return ResponseEntity.ok(playerService.attack(id, otherid));
//
//    }



}
