package src;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = DataLoader.getUsers();
    }

    public UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public boolean hasUser(UUID userID) {
        for(User user: users) {
            if(user.getID().equals(userID)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(UUID userID) {
        for(User user : users) {
            if(hasUser(userID)) {
                return user;
            }
        }
        return null;
    }
    // TODO Either edit arguments for User constructor 
    // OR figure out a way to get the users based on the UUID alone
    public void addUser(UUID userID) {
        if(!hasUser(userID)) {
            users.add(new User());
        }

    }

    public void deleteUser(UUID userID){
        if(!hasUser(userID)) {
            users.remove(getUser(userID));
        }
    }
    //TODO
    public void editUser(User user){

    }
    

}
