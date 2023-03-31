package src;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public boolean hasUser(UUID userID) {
        for(User user: users) {
            if(user.getUserID().equals(userID)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasUser(String username) {
        for(User user: users) {
            if(user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(UUID userID) {
        for(User user : users) {
            if(user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(String username) {
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username, String email, String password, String firstName, String lastName, UUID userID, String type) {
        if(!hasUser(userID)) {
            switch(type) {
                case "student":
                    users.add(new Student(username, email, password, firstName, lastName, userID));
                    break;
                case "teacher":
                    users.add(new Teacher(username, email, password, firstName, lastName, userID));
                    break;
                case "admin":
                    users.add(new Admin(username, email, password, firstName, lastName, userID));
                    break;
            }
        }
    }

    public void deleteUser(UUID userID){
        if(!hasUser(userID)) {
            users.remove(getUser(userID));
        }
    }

    public void saveUsers() {
        DataWriter.saveUsers();
    }

}
