import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private String name;
  private int id;
  private int stylistId;
  private boolean completed;


  public Client(String name, int stylistId) {
    this.name = name;
    this.stylistId = stylistId;
    completed = false;
  }

  public String getName() {
    return name;
  }

  public boolean isCompleted() {
    return completed;
  }

  public int getStylistId() {
    return stylistId;
  }

  public int getId() {
    return id;
  }

  public static List<Client> all() {
    String sql = "SELECT id, name, stylistId FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getId() == newClient.getId() &&
             this.getName().equals(newClient.getName()) &&
             this.getStylistId() == newClient.getStylistId();

    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(name, stylistId) VALUES (:name, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM clients where id=:id";
       Client client = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(Client.class);
       return client;
     }
   }

   public void update(String name) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "UPDATE clients SET name = :name WHERE id = :id";
       con.createQuery(sql)
       .addParameter("name", name)
       .addParameter("id", id)
       .executeUpdate();
  }
}


}
