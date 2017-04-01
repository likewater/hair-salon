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

  public int getId() {
    return id;
  }

  public static Stylist find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM stylists where id=:id";
       Stylist stylist = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(Stylist.class);
       return stylist;
     }
   }

   public List<Client> getClients() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM clients where stylistId=:id";
     return con.createQuery(sql)
       .addParameter("id", this.id)
       .executeAndFetch(Client.class);//changed typo here
   }
 }

   @Override
   public boolean equals(Object otherStylist) {
     if (!(otherStylist instanceof Stylist)) {
       return false;
     } else {
       Stylist newStylist = (Stylist) otherStylist;
       return this.getStylistLastName().equals(newStylist.getStylistLastName()) &&
              this.getStylistFirstName().equals(newStylist.getStylistFirstName()) &&
              this.getStylistStatus().equals(newStylist.getStylistStatus()) &&
              this.getId() == newStylist.getId();
     }
 }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(stylist_last_name, stylist_first_name, stylist_status) VALUES (:stylist_last_name, :stylist_first_name, :stylist_status)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("stylist_last_name", this.stylistLastName)
        .addParameter("stylist_first_name", this.stylistFirstName)
        .addParameter("stylist_status", this.stylistStatus)
        .executeUpdate()
        .getKey();
    }
  }

}
