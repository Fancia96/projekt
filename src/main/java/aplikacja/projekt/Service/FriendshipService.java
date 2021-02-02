package aplikacja.projekt.Service;

import aplikacja.projekt.Model.Friendship;
import aplikacja.projekt.Model.Person;
import aplikacja.projekt.Repository.FriendshipRepository;
import aplikacja.projekt.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendshipService {
    //jak usune osobe to usuam viadomosci z nia zviazene

    private FriendshipRepository friendshipRepository;
    private PersonRepository personRepository;

    public List<Friendship> findAll(){
        return friendshipRepository.findAll();
        //return null;
    }

    public Friendship findById(Long id){
        return null;
    }

    public Friendship findByName(Long id){
    return null;
    }

    public void deleteById(Long id){
        friendshipRepository.deleteById(id);
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
//        friendshipRepository.save(person);
//    }
//
//    public Friendship updatePersonById(Person player){
//        Optional<Friendship> personUpdate = friendshipRepository.findById(player.getID());
//        if(personUpdate != null){
//            //nie moge utworzyc
//        }
//        return friendshipRepository.save(player);
//    }

    public Friendship createFriendshipByID(Long personOneID, Long personTwoID){
        //szukam obiektow osoby po id
        Optional<Person> personOne = personRepository.findById(personOneID);
        Optional<Person> personTwo = personRepository.findById(personTwoID);

        if(personOne != null && personTwo != null){
            Friendship friendshipAdd = new Friendship(
                    personOne.get(), personTwo.get());
            return friendshipRepository.save(friendshipAdd);
        }
        throw new RuntimeException();
    }

    public FriendshipService(FriendshipRepository friendshipRepository, PersonRepository personRepository){
        this.friendshipRepository = friendshipRepository;
        this.personRepository = personRepository;
    }

     ///usuva tez liste przyjaciol i u nich tez
    //spravdza czy istnieje
}