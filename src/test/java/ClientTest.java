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

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
