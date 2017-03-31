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
}
