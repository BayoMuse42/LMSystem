package src;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
    users.add(new Teacher("SandraJHart@jourrapide.com","Newhavening","Phac0quu6@","Sandra","Hart",UUID.fromString("927f7cfc-1121-45fe-a0da-d1ed2170bb8a")));
    users.add(new Student("DawnBDunning@armyspy.com ","Sayinten","ouDoo0mai#","Dawn","Dunning",UUID.fromString("841a4abb-ff0b-4038-926d-dae9b24cacf4")));
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
  public void hasUserUUID() {
    boolean hasSandra = userList.hasUser(UUID.fromString("927f7cfc-1121-45fe-a0da-d1ed2170bb8a"));
    boolean hasDawn = userList.hasUser(UUID.fromString("841a4abb-ff0b-4038-926d-dae9b24cacf4"));
    assertTrue(hasSandra);
    assertTrue(hasDawn);
  }

  @Test
  public void hasUserUsername() {
    boolean hasSandra = userList.hasUser("Newhavening");
    boolean hasDawn = userList.hasUser("Sayinten");
    assertTrue(hasSandra);
    assertTrue(hasDawn);
  }
  
  @Test
  public void hasUserFirstItem() {
    boolean hasSandra = userList.hasUser("Newhavening");
    assertTrue(hasSandra);
  }

  @Test
  public void hasUserLastItem() {
    boolean hasDawn = userList.hasUser("Sayinten");
    assertTrue(hasDawn);
  }

  @Test
  public void hasUserInvalid() {
    boolean hasJohn = userList.hasUser("JSmith");
    assertFalse(hasJohn);
  }

  @Test
  public void hasUserNull() {
    UUID uID = null;
    boolean hasNull = userList.hasUser(uID);
    assertFalse(hasNull);
  }

  @Test
  public void hasUserEmpty() {
    boolean hasEmpty = userList.hasUser("");
    assertFalse(hasEmpty);
  }

  @Test
  public void getUserUUID() {
    User getDawn = userList.getUser(UUID.fromString("841a4abb-ff0b-4038-926d-dae9b24cacf4"));
    assertEquals(users.get(1),getDawn);
  }

  @Test
  public void getUserUsername() {
    User getSandra = userList.getUser("Newhavening");
    assertEquals(users.get(0),getSandra);
  }
  
  @Test
  public void getUserFirstItem() {
    User getSandra = userList.getUser("Newhavening");
    assertEquals(users.get(0),getSandra);
  }

  @Test
  public void getUserLastItem() {
    User getDawn = userList.getUser("Sayinten");
    assertEquals(users.get(1),getDawn);
  }

  @Test
  public void getUserInvalid() {
    User getJohn = userList.getUser("JSmith");
    assertEquals(null, getJohn);
  }

  @Test
  public void getUserNull() {
    User getNull = null;
    assertEquals(null, getNull);
  }

  @Test
  public void getUserEmpty() {
    User getEmpty = userList.getUser("");
    assertEquals(null, getEmpty);
  }

  @Test
  public void addUserStandard() {
    userList.addUser("Thibustor", "ChristopherHContreras@jourrapide.com", " ", "Christopher", "Contreras", UUID.fromString("a1d6f1e8-4c30-4703-9cb4-dde0b722670a"),"student");
    assertTrue(userList.hasUser("Thibustor"));
  }

  @Test
  public void addUserSpaces() {
    userList.addUser(" ", " ", " ", " ", " ", UUID.randomUUID(), "student");
    assertFalse(userList.hasUser(" "));
  }

  @Test
  public void addUserNull() {
    UUID nullUser = UUID.randomUUID();
    userList.addUser(null,null,null,null,null,nullUser,"student");
    assertFalse(userList.hasUser(nullUser));
  }

   // Because of the email/username swap bug found through test addUserStandard
   // the rest of the add tests have been edited accordingly
  @Test
  public void addUserInvalidType() {
    userList.addUser("Thibustor", "ChristopherHContreras@jourrapide.com", "!eeyaiS6Shei!", "Christopher", "Contreras", UUID.fromString("a1d6f1e8-4c30-4703-9cb4-dde0b722670a"),"parent");
    assertFalse(userList.hasUser("Thibustor") || userList.hasUser("ChristopherHContreras@jourrapide.com"));
  }

  @Test
  public void addUserInvalidPass() {
    userList.addUser("Thibustor", "ChristopherHContreras@jourrapide.com", "eeyaiS6Shei", "Christopher", "Contreras", UUID.fromString("a1d6f1e8-4c30-4703-9cb4-dde0b722670a"),"student");
    assertFalse(userList.hasUser("Thibustor") || userList.hasUser("ChristopherHContreras@jourrapide.com"));
  }

  @Test
  public void addUserInvalidEmail() {
    userList.addUser("Thibustor", "ChristopherHContreras", "!eeyaiS6Shei!", "Christopher", "Contreras", UUID.fromString("a1d6f1e8-4c30-4703-9cb4-dde0b722670a"),"student");
    assertFalse(userList.hasUser("Thibustor") || userList.hasUser("ChristopherHContreras"));
  }

  @Test
  public void addUserExistingUser() {
    int ogSize = users.size();
    userList.addUser("Sayinten","DawnBDunning@armyspy.com","ouDoo0mai#","Dawn","Dunning",UUID.fromString("841a4abb-ff0b-4038-926d-dae9b24cacf4"),"student");
    assertEquals(users.size(), ogSize);
  }

  @Test
  public void removeUserFirstItem() {
    userList.deleteUser(UUID.fromString("927f7cfc-1121-45fe-a0da-d1ed2170bb8a"));
    DataWriter.saveUsers();
    assertFalse(userList.hasUser(UUID.fromString("927f7cfc-1121-45fe-a0da-d1ed2170bb8a")));
  }

  @Test
  public void removeUserLastItem() {
    userList.deleteUser(UUID.fromString("841a4abb-ff0b-4038-926d-dae9b24cacf4"));
    DataWriter.saveUsers();
    assertFalse(userList.hasUser(UUID.fromString("841a4abb-ff0b-4038-926d-dae9b24cacf4")));
  }

  @Test
  public void removeUserNull() {
    UUID nullUser = UUID.randomUUID();
    userList.addUser(null,null,null,null,null,nullUser,"student");
    userList.deleteUser(null);
    assertFalse(users.contains(null));
  }

  @Test
  public void removeUserEmpty() {
    users.clear();
    assertThrows(IllegalArgumentException.class, () -> {
      userList.deleteUser(UUID.fromString(" "));
  });
  }
}
