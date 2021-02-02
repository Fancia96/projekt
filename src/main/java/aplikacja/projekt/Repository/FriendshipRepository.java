package aplikacja.projekt.Repository;

import aplikacja.projekt.Model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

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
