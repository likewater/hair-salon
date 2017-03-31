import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Test
  public void ClientInstantiatesCorrectly_true() {
    Client myClient = new Client("Simms", "Sally", "12/12/2016", "11/11/2005");
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void getClientLastName_returnsClientLastName_string() {
    Client myClient = new Client("Simms", "Sally", "12/12/2016", "11/11/2005");
    assertEquals("Simms", myClient.getClientLastName());
  }

  @Test
  public void getClientFirsttName_returnsClientFirstName_string() {
    Client myClient = new Client("Simms", "Sally", "12/12/2016", "11/11/2005");
    assertEquals("Sally", myClient.getClientFirstName());
  }

  @Test
  public void getClientLastVisit_returnsClientLastVisit_string() {
    Client myClient = new Client("Simms", "Sally", "12/12/2016", "11/11/2005");
    assertEquals("12/12/2016", myClient.getClientLastVisit());
  }

  @Test
  public void getClientFirstVisit_returnsClientFirstVisit_string() {
    Client myClient = new Client("Simms", "Sally", "12/12/2016", "11/11/2005");
    assertEquals("11/11/2005", myClient.getClientFirstVisit());
  }
}
