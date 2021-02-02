package aplikacja.projekt.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private String id;
    private String msg;

    public Message(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Message() {
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//    private String content;
//
//    @JoinColumn(name = "player_id")
//    @ManyToOne
//    @JsonIgnore // ZEBY SIE NIE WYWOALLO REKURENCYJNIE FETCH TYPE LAZY
//    private Player player;
//
//    public Message(String content, Player player) {
//        this.content = content;
//        this.player = player;
//    }
//
//    public Message() {
//
//    }