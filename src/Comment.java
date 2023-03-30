package src;
import java.util.UUID;
import java.util.ArrayList;

public class Comment {

    public String Reply;
    
    public String message;
    public ArrayList<Comment> replies;
    public UUID userID;

    public Comment(UUID userID, String message){
        this.message = message;
        this.userID = userID;
    }

    public Comment(UUID userID, String message, ArrayList<Comment> replies){
        this.message = message;
        this.replies = replies;
        this.userID = userID;
    }

    public void replyMessage(UUID userID, String message){
        Comment reply = new Comment(userID, message);
        replies.add(reply);
    }

    public String getMessage(){
        return this.message;
    }

    public UUID getUserID() {
        return this.userID;
    }
    
    public ArrayList<Comment> getReplies() {
        return this.replies;
    }

    public String toString() {
        return "Comment [Reply=" + Reply + ", message=" + message + ", replies=" + replies + ", userID=" + userID + "]";
    }

    
}
