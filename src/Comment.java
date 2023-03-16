package src;
import java.util.UUID;
import java.util.ArrayList;

public class Comment {

    public String message;
    public ArrayList<Comment> replies;
    public UUID userID;

    public Comment(String message){
        this.message = message;
    }

    public void replyMessage(String message){
        Comment reply = new Comment(message);
        replies.add(reply);
    }
    
}
