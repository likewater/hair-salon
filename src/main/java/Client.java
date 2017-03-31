import java.util.List;
import org.sql2o.*;

public class Client {
  private String clientLastName;
  private String clientFirstName;
  private String clientLastVisit;
  private String clientFirstVisit;
  private int id;


  public Client(String clientLastName, String clientFirstName, String clientLastVisit, String clientFirstVisit) {
    this.clientLastName = clientLastName;
    this.clientFirstName = clientFirstName;
    this.clientLastVisit = clientLastVisit;
    this.clientFirstVisit = clientFirstVisit;
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
}
