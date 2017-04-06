import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @Test
  public void ClientInstantiatesCorrectly_true() {
    Client myClient = new Client("Sally Simms", 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void getClientName_returnsClientName_string() {
    Client myClient = new Client("Sally Simms", 1);
    assertEquals("Sally Simms", myClient.getName());
  }

  @Test
  public void update_updatesClientName_true() {
    Client myClient = new Client("Sally Simms", 1);
    myClient.save();
    myClient.update("Sally Samms");
    assertEquals("Sally Samms", Client.find(myClient.getId()).getName());
  }

  @Test
  public void delete_deletesClient_true() {
    Client myClient = new Client("Sally Simms", 1);
    myClient.save();
    int myClientId = myClient.getId();
    myClient.delete();
    assertEquals(null, Client.find(myClientId));
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      String deleteClientsQuery = "DELETE FROM clients *;";
      con.createQuery(deleteStylistsQuery).executeUpdate();
      con.createQuery(deleteClientsQuery).executeUpdate();
    }
  }
}
