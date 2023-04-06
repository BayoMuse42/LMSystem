package src;
import java.util.UUID;
import java.util.ArrayList;

public class Comment {

    public String Reply;
    public String message;
    public ArrayList<Comment> replies;
    public UUID userID;

    /**
     * 
     * @param userID
     * @param message
     * Comment constructor
     */
    public Comment(UUID userID, String message){
        this.message = message;
        this.userID = userID;
    }

    /**
     * 
     * @param userID
     * @param message
     * @param replies
     * overloaded constructor takes arraylist of comments saved as replies
     */
    public Comment(UUID userID, String message, ArrayList<Comment> replies){
        this.message = message;
        this.replies = replies;
        this.userID = userID;
    }

    /**
     * 
     * @param userID
     * @param message
     * replyMessage method takes User ID and message, saves to replies arraylist
     */
    public void replyMessage(UUID userID, String message){
        Comment reply = new Comment(userID, message);
        replies.add(reply);
    }

    /**
     * 
     * @return String, message contained in comment
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * 
     * @return UUID of user who owns comment
     */
    public UUID getUserID() {
        return this.userID;
    }
    
    /**
     * 
     * @return ArrayList of comments storing replies
     */
    public ArrayList<Comment> getReplies() {
        return this.replies;
    }

    /**
     * @return returns description of comment and replies
     */
    public String toString() {
        String output = "";
        output += "COMMENT: " + message;
        for (int i = 0; i < replies.size(); i++){
            output += "REPLY " + i + ": " + replies.get(i) + "\n";
        }
        return output;
    }

    
}
