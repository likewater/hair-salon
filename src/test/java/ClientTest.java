import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  @Test
  public void ClientInstantiatesCorrectly_true() {
    Client myClient = new Client();
    assertEquals(true, myClient instanceof Client);
  }
}
