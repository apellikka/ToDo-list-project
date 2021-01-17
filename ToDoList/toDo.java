
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

  public void setUrgency() {
    if (this.urgentTask = false) {
      this.urgentTask = true;
    }
    this.urgentTask = false;
  }

  public String toString() {
    if (this.urgentTask = true) {
      return this.name + " (Urgent)";
    }
    return this.name;
  }


}
