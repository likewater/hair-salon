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
    assertEquals("Danny Ritchie", myStylist.getName());
  }

  @Test
   public void getId_stylistInstantiateWithAnId_1() {
     Stylist myStylist = new Stylist("Danny Ritchie");
     myStylist.save();
     assertTrue(myStylist.getId() > 0);
   }

   @Test
   public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Danny Ritchie");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Danny Ritchie");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void update_updatesStylistName_true() {
    Stylist myStylist = new Stylist("Fawn Henry");
    myStylist.save();
    myStylist.update("Dawn Henry");
    assertEquals("Dawn Henry", Stylist.find(myStylist.getId()).getName());
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist myStylist = new Stylist("Fawn Henry");
    myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete();
    assertEquals(null, Stylist.find(myStylistId));
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
