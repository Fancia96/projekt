package aplikacja.projekt.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PW {
    //lista id osob v danej konversacji, id konversacji

    @Id
    @GeneratedValue
    private Long id_pw;

    //zaiera liste osob  tej conversacji viec moge szukac czy istnieja
    //osoba ktora utvorzyla jest liderem i tylko ta nazva, lub id moze usunac konvo
    @OneToOne
    private Person leader;

    @ManyToOne
    private Person listConvoPeople;

    public PW(Person leader, List<Person> listConvoPeople){

        //dajemy od razu osoby do przed vyslaniem viadomosci nam znajdzie  id choc i tak szukamy po nazvie

       //this.listConvoPeople = new ArrayList<Person>();
       //this.listConvoPeople.add(leader);

        this.leader = leader;
    }

    public PW() {

    }
}
