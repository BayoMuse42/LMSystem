package src;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.UUID;

public class CommentTest {
    public String Reply;
    public String message;
    public ArrayList<Comment> replies;
    public UUID userID;

    @BeforeEach
    public void setup(){
        replies = new ArrayList<Comment>();

        replies = new ArrayList<Comment>();
        replies.add("Great Job!");
        replies.add("Well Done!");
        replies.add("Awesome Work!");

        replies = new Reply(replies);

    }

    @AfterEach
    public void tearDown(){

    }

    @Test
    public void testing(){
        assertionTrue(true);
    }
    
    /** Gets the messages r 
     * @return messgae
     */
    @Test
    public String hasMessage() {
        return this.message
    }
    @Test
    public UUID hasUserID(){
        return this.userID;
    }

    @Test
    public String toString() {
        String output = "";
        output += "COMMENT: " + message;
        for (int i = 0; i < replies.size(); i++){
            output += "REPLY " + i + ": " + replies.get(i) + "\n";
        }
        return output;
    
    }



}
