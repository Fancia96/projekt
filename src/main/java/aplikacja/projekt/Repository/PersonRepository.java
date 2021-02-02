package aplikacja.projekt.Repository;

import aplikacja.projekt.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

   // @Query(" SELECT p from Person p where p.nickname LIKE :text order by p.nickname")
   // List<Person> findPlayersContainsString(String text);

//    @Transactional
//    public default void insertWithQuery(Person person) {
//        entityManager.createNativeQuery(
//                "INSERT INTO person (nickname, last_name) VALUES (?,?,?)")
//                .setParameter(1, person.getId())
//                .setParameter(2, person.getFirstName())
//                .setParameter(3, person.getLastName())
//                .executeUpdate();
//    }

   // Person findByNickname();

   // Person findByID();
}
