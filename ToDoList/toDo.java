import java.util.*;

public class toDo {

  private String name;
  private boolean urgentTask;

  public toDo(String name) {
    this.name = name;
    this.urgentTask = false;
  }

  public void setName(String setName) {
    this.name = setName;
  }

  public String getName() {
    return this.name;
  }

  public void setUrgency(boolean setUrgency) {
    this.urgentTask = setUrgency;
  }

  public boolean getUrgency() {
    return this.urgentTask;
  }

  public String toString() {
    if (this.urgentTask == true) {
      return this.name + " (Urgent)";
    }
    return this.name;
  }
}
