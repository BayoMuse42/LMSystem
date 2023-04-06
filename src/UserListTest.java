package src;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.UUID;

public class UserListTest {
  private UserList userList = UserList.getInstance();
  private ArrayList<User> users = userList.getUsers();

  @BeforeEach
  public void setup() {
    users.clear();
    users.add(new User());
    users.add(new User());
    DataWriter.saveUsers();
  }

  @AfterEach
  public void tearDown() {
    UserList.getInstance().getUsers().clear();
    DataWriter.saveUsers();
  }

  @Test
  public void testing() {
    assertTrue(true);
  }

  @Test
  void hasUserUUID() {

  }

  @Test
  void hasUserUsername() {

  } 
}
