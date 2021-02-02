package aplikacja.projekt.Controller;

import aplikacja.projekt.Model.Friendship;
import aplikacja.projekt.Model.Person;
import aplikacja.projekt.Service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    //czy istnieje , szukam po nicku
    @PostMapping("/addFriendship/{personOneID}/{personTwoID}")
    public ResponseEntity<Friendship> addFriendship(
            @PathVariable Long personOneID, @PathVariable Long personTwoID){
        Friendship  createThisFriendship = friendshipService.createFriendshipByID(
                personOneID, personTwoID);

        return ResponseEntity.ok(createThisFriendship);
    }

    @GetMapping("/getAllFriendship")
    public ResponseEntity<List<Friendship>> findAll() {

        return ResponseEntity.ok(friendshipService.findAll());
    }

}
