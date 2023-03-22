package src;
import java.util.UUID;
import java.util.ArrayList;

public class Comment {

    public String message;
    public ArrayList<Comment> replies;
    public UUID userID;

    public Comment(UUID userID, String message){
        this.message = message;
        this.userID = userID;
    }

    public Comment(UUID userID, String message, ArrayList<Comment> replies){
        this.message = message;
        this.replies = new ArrayList<Comment>();
    }

    public void replyMessage(String message){
        Comment reply = new Comment(message);
        replies.add(reply);
    }

    public String getMessage(){
        return this.message;
    }
    
}
