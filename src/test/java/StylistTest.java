import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Test
  public void StylistInstantiatesCorrectly_true() {
    Stylist myStylist = new Stylist();
    assertEquals(true, myStylist instanceof Stylist);
  }

}
