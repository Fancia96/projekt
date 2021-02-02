package aplikacja.projekt.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Friendship {
    @Id
    @GeneratedValue
    private Long ID;

    @JoinColumn(name = "personOne_id")
    @JsonBackReference
    @ManyToOne
    private Person personOne;

    @JoinColumn(name = "personTwo_id")
    @JsonBackReference
    @ManyToOne
    private Person personTwo;

    public Friendship() {
    }

    public Friendship(Person personOne, Person personTwo) {
        this.personOne = personOne;
        this.personTwo = personTwo;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public void setPersonOne(Person personOne) {
        this.personOne = personOne;
    }

    public Person getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(Person personTwo) {
        this.personTwo = personTwo;
    }
}
