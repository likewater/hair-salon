import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private int id;
  //private static List<Stylist> stylists = new ArrayList<Stylist>();
  //private List<Client> clients;
  //private static ArrayList<Team> team = new ArrayList<Team>();

  public Stylist(String name) {
    this.name = name;
    // this.id = stylists.size();
    // this.clients = new ArrayList<Client>();
    // stylists.add(this);
  }

  public String getName() {
    return stylistLastName;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, name FROM stylists";
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
       return this.getId() == newStylist.getId() &&
              this.getStylistLastName().equals(newStylist.getStylistLastName());
     }
 }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

}
