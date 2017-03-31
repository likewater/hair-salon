import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
    public void setUp() {
      DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    }

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
  //need to add data to DB to test
  // @Test
  // public void getAll_returnsIntegerAmount_integer() {
  //   Stylist myStylist = new Stylist("Ritchie", "Danny", "FT");
  //   assertEquals(4, myStylist.all().size());
  // }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists *;";
      con.createQuery(sql).executeUpdate();
    }
  }


}
