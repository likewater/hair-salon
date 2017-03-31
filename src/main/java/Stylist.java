import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Stylist {
  private String stylistLastName;
  private String stylistFirstName;
  private String stylistStatus;
  private int id;

  public Stylist(String stylistLastName, String stylistFirstName, String stylistStatus) {
    this.stylistLastName = stylistLastName;
    this.stylistFirstName = stylistFirstName;
    this.stylistStatus = stylistStatus;
  }

  public String getStylistLastName() {
    return stylistLastName;
  }

  public String getStylistFirstName() {
    return stylistFirstName;
  }

  public String getStylistStatus() {
    return stylistStatus;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, stylist_last_name, stylist_first_name, stylist_status FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }
}
