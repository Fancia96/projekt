package aplikacja.projekt.Service;

import aplikacja.projekt.Model.Friendship;
import aplikacja.projekt.Model.Person;
import aplikacja.projekt.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    //jak usune osobe to usuam viadomosci z nia zviazene

    private PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
        //return null;
    }

    public Person findById(Long id){
        return null;
    }

    public Person findByName(Long id){
    return null;
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }

    public void deleteByName(){

    }

//    public Friendship addFriend(Person person, Person friend){
//        person.getListOfFriends().add(new Friendship(person, friend));
//        //friend.getListOfFriends().add(person);
//
////        if(personRepository.save(person) != null &&
////                personRepository.save(friend) != null){
////            return (personRepository.saveAll(List.of(person, friend)));
////        }
//        personRepository.save(person);
//    }

    public Person updatePersonById(Person player){
        Optional<Person> personUpdate = personRepository.findById(player.getID());
        if(personUpdate != null){
            //nie moge utworzyc
        }
        return personRepository.save(player);
    }

    public Person createPerson(Person player){
        Person personAdd = new Person("Fancia");

        return personRepository.save(player);
    }

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


     ///usuva tez liste przyjaciol i u nich tez
    //spravdza czy istnieje
}

//
//    public List<Player> findAll() {
//        return playerRepository.findAll();
//    }
//    public Optional<Player> findById(Long id){
//        if(id == 10l){
//            throw new RuntimeException();
//        }
//        else {
//            return playerRepository.findById(id);
//        }
//    }

//    public Player makePoisoned(Long attackerId, Long defenderId) {
//
//        Player attacker = findById(attackerId).get();
//        Player defender = findById(defenderId).get();
//
//
//        defender = damageService.makePoisoned(attacker, defender);
//
//        return update(defender);
//        //defend.
//        //return update(damageService.attackPlayer(attacker, defender));
//    }