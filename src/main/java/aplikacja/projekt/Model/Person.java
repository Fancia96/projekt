package aplikacja.projekt.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nickname;


//    @JoinTable(name="tbl_friends",
//            joinColumns=@JoinColumn(name="personId"),
//            inverseJoinColumns=@JoinColumn(name="friendId")
//    )

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personOne")
    private List<Friendship> ListOfFriends = new ArrayList<Friendship>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personTwo")
    private List<Friendship> ListOfFriendsTwo = new ArrayList<Friendship>();

//    @ManyToMany
//    @JoinTable(name="tbl_friends",
//            joinColumns=@JoinColumn(name="friendId"),
//            inverseJoinColumns=@JoinColumn(name="personId")
//    )
//    private List<Person> friendOf;

    public void setListOfFriendsTwo(List<Friendship> listOfFriendsTwo) {
        ListOfFriendsTwo = listOfFriendsTwo;
    }

    public List<Friendship> getListOfFriends() {
        return ListOfFriends;
    }

    public List<Friendship> getListOfFriendsTwo() {
        return ListOfFriendsTwo;
    }

    public void setListOfFriends(List<Friendship> listOfFriends) {
        ListOfFriends = listOfFriends;
    }

    public Person() {
        this.nickname = "nick"+getID();
    }

    public Person(String nickname) {
        this.nickname = nickname;
    }

    public Long getID() {
        return ID;
    }
    @JsonIgnore
    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        String friends = "";
        for(Friendship person : getListOfFriends()){
            //friends += person.getNickname();
        }


        return "Person{" +
                "ID=" + ID +
                ", nickname='" + nickname +"}";
    }

//    public List<Person> getFriendOf() {
//        return friendOf;
//    }
//
//    public void setFriendOf(List<Person> friendOf) {
//        this.friendOf = friendOf;
//    }
    // moge pokazacvvspolnych znajomych
    //spravvdzanie przy vpisyvvaniu nazvy
}

//{"nickname": "Fancia", "listOfFriends": null}
