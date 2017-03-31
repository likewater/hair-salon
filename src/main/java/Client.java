import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String clientLastName;
  private String clientFirstName;
  private String clientLastVisit;
  private String clientFirstVisit;
  private int id;
  private int stylistId;


  public Client(String clientLastName, String clientFirstName, String clientLastVisit, String clientFirstVisit, int stylistId) {
    this.clientLastName = clientLastName;
    this.clientFirstName = clientFirstName;
    this.clientLastVisit = clientLastVisit;
    this.clientFirstVisit = clientFirstVisit;
    this.stylistId = stylistId;
    completed = false;
  }

  public String getClientLastName() {
    return clientLastName;
  }

  public String getClientFirstName() {
    return clientFirstName;
  }

  public String getClientLastVisit() {
    return clientLastVisit;
  }

  public String getClientFirstVisit() {
    return clientFirstVisit;
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
    String sql = "SELECT id, client_last_name, client_first_name, client_last_visit, client_first_visit, stylistId FROM clients";
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
      return this.getClientLastName().equals(newClient.getClientLastName()) &&
             this.getClientFirstName().equals(newClient.getClientFirstName()) &&
             this.getClientLastVisit().equals(newClient.getClientLastVisit()) &&
             this.getClientFirstVisit().equals(newClient.getClientFirstVisit()) &&
             this.getStylisId() == newClient.getStylistId(); &&
             this.getId() == newClient.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(client_last_name, client_first_name, client_last_visit, client_first_visit, stylistId) VALUES (:client_last_name, :client_first_name, :client_last_visit, :client_first_visit, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("client_last_name", this.clientLastName)
        .addParameter("client_first_name", this.clientFirstName)
        .addParameter("client_last_visit", this.clientLastVisit)
        .addParameter("client_first_visit", this.clientFirstVisit)
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




}
