import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class StylistTest {

  @Before
    public void setUp() {
      DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    }

  @Test
  public void StylistInstantiatesCorrectly_true() {
    Stylist myStylist = new Stylist("Danny Ritchie");
    assertEquals(true, myStylist instanceof Stylist);
  }

  @Test
  public void getStylistName_returnsStylistName_string() {
    Stylist myStylist = new Stylist("Danny Ritchie");
    assertEquals("Danny Ritchie", myStylist.getStylistLastName());
  }

  @Test
   public void getId_stylistInstantiateWithAnId_1() {
     Stylist myStylist = new Stylist("Danny Ritchie");
     myStylist.save();
     assertTrue(myStylist.getId() > 0);
   }

  //  @Test
  //  public void all_returnsAllInstancesOfStylist_true() {
  //    Stylist firstStylist = new Stylist("Ritchie", "Danny", "FT");
  //    firstStylist.save();
  //    Stylist secondStylist = new Stylist("Ritchie", "Danny", "FT");
  //    secondStylist.save();
  //    assertEquals(true, Stylist.all().get(1).equals(firstStylist));
  //    assertEquals(true, Stylist.all().get(2).equals(secondStylist));
  // }

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
