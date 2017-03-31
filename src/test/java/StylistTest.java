import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Test
  public void StylistInstantiatesCorrectly_true() {
    Stylist myStylist = new Stylist("Ritchie", "Danny", "FT");
    assertEquals(true, myStylist instanceof Stylist);
  }

  @Test
  public void getStylistLastName_returnsStylistLastName_string() {
    Stylist myStylist = new Stylist("Ritchie", "Danny", "FT");
    assertEquals("Ritchie", myStylist.getStylistLastName());
  }

  @Test
  public void getStylistFirstName_returnsStylistFirstName_string() {
    Stylist myStylist = new Stylist("Ritchie", "Danny", "FT");
    assertEquals("Danny", myStylist.getStylistFirstName());
  }

  @Test
  public void getStylistStatusreturnsStylistLastStatus_string() {
    Stylist myStylist = new Stylist("Ritchie", "Danny", "FT");
    assertEquals("FT", myStylist.getStylistStatus());
  }


}
