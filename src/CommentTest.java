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
    private Comment comment;

    @BeforeEach
    public void setup(){
        replies = new ArrayList<Comment>();
        userID = UUID.randomUUID();
        
        replies.add(new Comment(userID, "Great Job!"));
        replies.add(new Comment(userID, "Well Done!"));
        replies.add(new Comment(userID, "Awesome Work!"));

        comment = new Comment(userID, "Just finished course", replies);

    }

    @AfterEach
    public void tearDown(){

    }

    @Test
    public void testing(){
        assertTrue(true);
    }
    
    /** Gets the messages r 
     * @return messgae
     */
    @Test
    public void hasMessage() {
        Boolean test1 = true;
        if (!comment.getMessage().equals("Just finished course")){
            test1 = false;
        }
        assertTrue(test1);
    }

    @Test
    public void hasUserID(){
        Boolean test2 = true;
        if (!comment.getUserID().equals(userID)){
            test2 = false;
        }
        assertTrue(test2);
    }

    @Test
    public void hasReplies(){
        Boolean test3 = true;
        ArrayList<Comment> testReplies = comment.getReplies();
        int i = 0;
        for (Comment c: testReplies){
            String testMessage = c.getMessage();
            Comment c2 = replies.get(i);
            String rmessage = c2.getMessage();
            if (!testMessage.equals(rmessage)){
                test3 = false;
            }
            i++;
        }
        assertTrue(test3);
    }
}
